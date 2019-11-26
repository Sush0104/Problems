package com.fx.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.fx.dao.FXCalculatorDao;
import com.fx.exception.FXSystemException;
import com.fx.main.FXCalculator;
import com.fx.model.Currency;
import com.fx.model.PairRates;
import com.fx.model.RelationType;

public class FXCalculatorServiceImpl implements IFXCalculatorService {
	private FXCalculatorDao fxCalculatorDao;
	private Double convertedAmount;
	private final Logger log = Logger.getLogger(String
			.valueOf(FXCalculator.class));
	private String baseTermRelationsType = "";
	private List<PairRates> currencyRates;

	public void getConvertedValues(String input) throws FXSystemException {
		fxCalculatorDao = new FXCalculatorDao();
		Object[] inputValuesArray = input.split("\\s+");

		log.info(inputValuesArray[1].toString());
		String base = (String) inputValuesArray[0];
		String term = (String) inputValuesArray[3];
		Double amount = Double.valueOf(inputValuesArray[1].toString());
		currencyRates = fxCalculatorDao.getCurrencyRates();
		log.info(currencyRates.toString());
		checkIfBaseTermAreInvalidCurrencies(base, term);
		for (PairRates p : currencyRates) {
			if (p.getBase().equals(base) & p.getTerm().equals(term)) {
				convertedAmount = getFormattedAmount(base, amount * p.getRate());
			}
		}
		if (convertedAmount != null) {
			convertedAmount = getCrossedCurrencyConversionValues(base, term,
					amount);
		}
		log.info(base + " " + amount + " = " + convertedAmount + " " + term);

	}

	private void checkIfBaseTermAreInvalidCurrencies(String base, String term)
			throws FXSystemException {
		try {
			Currency.valueOf(base);
			Currency.valueOf(term);
		} catch (Exception exception) {
			throw new FXSystemException(
					"The base = +"
							+ base
							+ " or term = "
							+ term
							+ " is invalid.Please enter a valid currency and try again.");
		}
	}

	public Double getCrossedCurrencyConversionValues(String base, String term,
			Double amount) {

		Double firstRate = 0.0;
		Double secondRate = 0.0;
		String tempBase = "";
		String tempTerm = "";
		baseTermRelationsType = searchMatrix(base, term);
		while (!baseTermRelationsType.isEmpty()
				& !baseTermRelationsType.equals(RelationType.DIRECT.toString())
				& !baseTermRelationsType.equals(RelationType.ONE_ON_ONE
						.toString())
				& !baseTermRelationsType.equals(RelationType.INV.toString())) {
			tempBase = base;
			tempTerm = baseTermRelationsType;
			baseTermRelationsType = searchMatrix(tempBase, tempTerm);
		}
		PairRates firstPair = new PairRates(tempBase, tempTerm, 0);
		tempBase = tempTerm;
		baseTermRelationsType = searchMatrix(tempBase, term);
		while (!baseTermRelationsType.isEmpty()
				& !baseTermRelationsType.equals(RelationType.DIRECT.toString())
				& !baseTermRelationsType.equals(RelationType.ONE_ON_ONE
						.toString())
				& !baseTermRelationsType.equals(RelationType.INV.toString())) {
			tempBase = tempTerm;
			tempTerm = baseTermRelationsType;
			baseTermRelationsType = searchMatrix(tempBase, term);
		}
		PairRates secondPair = new PairRates(tempBase, term, 0);
		for (PairRates p : currencyRates) {
			if (p.getBase().equals(firstPair.getBase())
					&& p.getTerm().equals(firstPair.getTerm())) {
				firstRate = p.getRate();
			} else if (p.getBase().equals(secondPair.getBase())
					&& p.getTerm().equals(secondPair.getTerm())) {
				secondRate = p.getRate();
			}
		}
		convertedAmount = amount * firstRate * secondRate;
		return getFormattedAmount(base, convertedAmount);

	}

	public String searchMatrix(String base, String term) {
		if (base.equals(term)) {
			return RelationType.ONE_ON_ONE.toString();
		}
		Map<String, String> baseMatrix = fxCalculatorDao.getMatrix().get(base);
		if (baseMatrix != null) {
			return baseMatrix.get(term);
		}
		return String.valueOf("");
	}

	public Double getFormattedAmount(String base, Double convertedAmount) {
		BigDecimal formattedAmount = new BigDecimal(convertedAmount);
		return formattedAmount.setScale(
				fxCalculatorDao.getDecimalFormat().get(base),
				BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}

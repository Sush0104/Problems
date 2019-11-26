package com.fx.dao;

import com.fx.model.GetPairFactory;
import com.fx.model.PairRates;
import com.fx.model.Currency;
import com.fx.model.RelationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FXCalculatorDao {
private GetPairFactory getPairFactory;
    public List <PairRates> getCurrencyRates(){
        getPairFactory=new GetPairFactory();
        List<PairRates> allPairRates =new ArrayList<>();
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("AUD","USD",0.8371));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("CAD","USD",0.8711));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("USD","CNY",6.1715));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("EUR","USD",1.2315));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("GBP","USD",1.5683));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("USD","JPY",119.95));
    
        return  allPairRates;
    }

    public Map<String , Integer>  getDecimalFormat(){
        HashMap<String, Integer> decimalFormats = new HashMap<>();
        decimalFormats.put("AUD",2);
        decimalFormats.put("CAD",2);
        decimalFormats.put("JPY",0);
        decimalFormats.put("GBP",2);
        return decimalFormats;
    }

    public Map<String,Map<String,String>> getMatrix() {
        Map<String,Map<String,String>> matrix =new HashMap<>();
        HashMap<String, String> relationshipValuesAUD = new HashMap<>();
        relationshipValuesAUD.put(Currency.AUD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesAUD.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        matrix.put(Currency.AUD.toString(),relationshipValuesAUD);

        HashMap<String, String> relationshipValuesJPY = new HashMap<>();
        relationshipValuesJPY.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.JPY.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesJPY.put(Currency.USD.toString(),RelationType.INV.toString());
        matrix.put(Currency.JPY.toString(),relationshipValuesJPY);

        HashMap<String, String> relationshipValuesUSD = new HashMap<>();
        relationshipValuesUSD.put(Currency.AUD.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.USD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesUSD.put(Currency.JPY.toString(),RelationType.DIRECT.toString());
        relationshipValuesUSD.put(Currency.EUR.toString(),RelationType.INV.toString());
        matrix.put(Currency.USD.toString(),relationshipValuesUSD);
        
        HashMap<String, String> relationshipValuesGBP = new HashMap<>();
        relationshipValuesGBP.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        matrix.put(Currency.GBP.toString(),relationshipValuesGBP);
        
        HashMap<String, String> relationshipValuesEUR = new HashMap<>();
        relationshipValuesEUR.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesEUR.put(Currency.JPY.toString(),RelationType.DIRECT.toString());
        matrix.put(Currency.EUR.toString(),relationshipValuesEUR);

        return matrix;
    }
}

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
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("EUR","CZK",27.6028));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("EUR","DKK",7.4405));
        allPairRates.addAll(getPairFactory.getCoupleOfPairs("EUR","NOK",8.6651));
        return  allPairRates;
    }

    public Map<String , Integer>  getDecimalFormat(){
        HashMap<String, Integer> decimalFormats = new HashMap<>();
        decimalFormats.put("CAD",2);
        decimalFormats.put("CNY",2);
        decimalFormats.put("CZK",2);
        decimalFormats.put("DKK",2);
        decimalFormats.put("EUR",2);
        decimalFormats.put("GBP",2);
        decimalFormats.put("NOK",2);
        decimalFormats.put("JPY",0);
        decimalFormats.put("NZD",2);
        decimalFormats.put("USD",2);
        return decimalFormats;
    }

    public Map<String,Map<String,String>> getMatrix() {
        Map<String,Map<String,String>> matrix =new HashMap<>();
        HashMap<String, String> relationshipValuesAUD = new HashMap<>();
        relationshipValuesAUD.put(Currency.AUD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesAUD.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesAUD.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesAUD.put(Currency.NZD.toString(),Currency.USD.toString());
        matrix.put(Currency.AUD.toString(),relationshipValuesAUD);
        
        HashMap<String, String> relationshipValuesCAD = new HashMap<>();
        relationshipValuesCAD.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.CAD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesCAD.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesCAD.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesCAD.put(Currency.NZD.toString(),Currency.USD.toString());
        matrix.put(Currency.CAD.toString(),relationshipValuesCAD);
        
        HashMap<String, String> relationshipValuesCNY = new HashMap<>();
        relationshipValuesCNY.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesCNY.put(Currency.CNY.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesCNY.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesCNY.put(Currency.NZD.toString(),Currency.USD.toString());
        matrix.put(Currency.CNY.toString(),relationshipValuesCNY);
        
        HashMap<String, String> relationshipValuesCZK = new HashMap<>();
        relationshipValuesCZK.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.CZK.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesCZK.put(Currency.DKK.toString(),Currency.EUR.toString());
        relationshipValuesCZK.put(Currency.EUR.toString(),RelationType.INV.toString());
        relationshipValuesCZK.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.NOK.toString(),Currency.EUR.toString());
        relationshipValuesCZK.put(Currency.NZD.toString(),Currency.USD.toString());
        relationshipValuesCZK.put(Currency.USD.toString(),Currency.EUR.toString());
        matrix.put(Currency.CZK.toString(),relationshipValuesCZK);
        
        HashMap<String, String> relationshipValuesDKK = new HashMap<>();
        relationshipValuesDKK.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.CZK.toString(),Currency.EUR.toString());
        relationshipValuesDKK.put(Currency.DKK.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesDKK.put(Currency.EUR.toString(),RelationType.INV.toString());
        relationshipValuesDKK.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.NOK.toString(),Currency.EUR.toString());
        relationshipValuesDKK.put(Currency.NZD.toString(),Currency.USD.toString());
        relationshipValuesDKK.put(Currency.USD.toString(),Currency.EUR.toString());
        matrix.put(Currency.DKK.toString(),relationshipValuesDKK);

        HashMap<String, String> relationshipValuesEUR = new HashMap<>();
        relationshipValuesEUR.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesEUR.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesEUR.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesEUR.put(Currency.CZK.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.DKK.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.EUR.toString(),RelationType.ONE_ON_ONE.toString());  
        relationshipValuesEUR.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesEUR.put(Currency.JPY.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.NOK.toString(),RelationType.DIRECT.toString());
        relationshipValuesEUR.put(Currency.NZD.toString(),Currency.USD.toString());
    
        matrix.put(Currency.EUR.toString(),relationshipValuesEUR);
        
        HashMap<String, String> relationshipValuesGBP = new HashMap<>();
        relationshipValuesGBP.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.EUR.toString(),Currency.USD.toString());  
        relationshipValuesGBP.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        relationshipValuesGBP.put(Currency.GBP.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesGBP.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesGBP.put(Currency.NZD.toString(),Currency.USD.toString());
        matrix.put(Currency.GBP.toString(),relationshipValuesGBP);
        
        HashMap<String, String> relationshipValuesJPY = new HashMap<>();
        relationshipValuesJPY.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.JPY.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesJPY.put(Currency.USD.toString(),RelationType.INV.toString());
        relationshipValuesJPY.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesJPY.put(Currency.NZD.toString(),Currency.USD.toString());
        matrix.put(Currency.JPY.toString(),relationshipValuesJPY);
        
        HashMap<String, String> relationshipValuesNOK = new HashMap<>();
        relationshipValuesNOK.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.CZK.toString(),Currency.EUR.toString());
        relationshipValuesNOK.put(Currency.DKK.toString(),Currency.EUR.toString());
        relationshipValuesNOK.put(Currency.EUR.toString(),RelationType.INV.toString());  
        relationshipValuesNOK.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.NOK.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesNOK.put(Currency.NZD.toString(),Currency.USD.toString());
        relationshipValuesNOK.put(Currency.USD.toString(),Currency.EUR.toString());
        matrix.put(Currency.NOK.toString(),relationshipValuesNOK);
       
        HashMap<String, String> relationshipValuesNZD = new HashMap<>();
        relationshipValuesNZD.put(Currency.AUD.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.CAD.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.CNY.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.CZK.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.DKK.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.EUR.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.GBP.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.JPY.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.NOK.toString(),Currency.USD.toString());
        relationshipValuesNZD.put(Currency.NZD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesNZD.put(Currency.USD.toString(),RelationType.DIRECT.toString());
        matrix.put(Currency.EUR.toString(),relationshipValuesNZD);
       

        HashMap<String, String> relationshipValuesUSD = new HashMap<>();
        relationshipValuesUSD.put(Currency.AUD.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.USD.toString(),RelationType.ONE_ON_ONE.toString());
        relationshipValuesUSD.put(Currency.JPY.toString(),RelationType.DIRECT.toString());
        relationshipValuesUSD.put(Currency.EUR.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.CAD.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.CNY.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.CZK.toString(),Currency.EUR.toString());
        relationshipValuesUSD.put(Currency.DKK.toString(),Currency.EUR.toString());
        relationshipValuesUSD.put(Currency.GBP.toString(),RelationType.INV.toString());
        relationshipValuesUSD.put(Currency.NOK.toString(),Currency.EUR.toString());
        relationshipValuesUSD.put(Currency.NZD.toString(),RelationType.INV.toString());
        matrix.put(Currency.USD.toString(),relationshipValuesUSD);
 
        return matrix;
    }
}

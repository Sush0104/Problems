package com.fx.model;

import java.util.ArrayList;
import java.util.List;


public class GetPairFactory {

    public List<PairRates> getCoupleOfPairs(String base, String term, Double rate){

        PairRates inputPair= new PairRates(base,term,rate);
        Double invertedRate=1/rate;
        PairRates invertedPair = new PairRates(term,base,invertedRate);
       ArrayList<PairRates> pairRatesList = new ArrayList<PairRates>();
       pairRatesList.add(inputPair);
       pairRatesList.add(invertedPair);
       return pairRatesList;
       }

}

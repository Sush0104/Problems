package com.fx.model;

import java.util.Objects;

public class PairRates {

    private  String base;
    private  String term;
    private double rate;

    public PairRates(String base, String term, double rate) {
        this.base = base;
        this.term = term;
        this.rate = rate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairRates pairRates = (PairRates) o;
        return base.equals(pairRates.base) &&
                term.equals(pairRates.term);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, term);
    }

    @Override
    public String toString() {
        return "PairRates{" +
                "base='" + base + '\'' +
                ", term='" + term + '\'' +
                ", rate=" + rate +
                '}';
    }
}

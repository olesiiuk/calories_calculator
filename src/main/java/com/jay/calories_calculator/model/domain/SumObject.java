package com.jay.calories_calculator.model.domain;

import java.util.Objects;

public class SumObject {
    private int calories;

    private Double proteins;

    private Double fats;

    private Double starches;

    public SumObject() {
    }

    public SumObject(int calories, Double proteins, Double starches, Double fats) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.starches = starches;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }

    public Double getStarches() {
        return starches;
    }

    public void setStarches(Double starches) {
        this.starches = starches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SumObject sumObject = (SumObject) o;
        return getCalories() == sumObject.getCalories() &&
                Objects.equals(getProteins(), sumObject.getProteins()) &&
                Objects.equals(getFats(), sumObject.getFats()) &&
                Objects.equals(getStarches(), sumObject.getStarches());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCalories(), getProteins(), getFats(), getStarches());
    }
}

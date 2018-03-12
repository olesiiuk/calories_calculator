package com.jay.calories_calculator.model.domain;

import java.util.Objects;

public class SumObject {
    private Double calories;

    private Double proteins;

    private Double fats;

    private Double starches;

    public SumObject() {
    }

    public SumObject(Double calories, Double proteins, Double starches, Double fats) {
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.starches = starches;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
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

        boolean isEqualCal = getCalories().compareTo(sumObject.getCalories()) == 0;
        boolean isEqualProteins = getProteins().compareTo(sumObject.getProteins()) == 0;
        boolean isEqualFats = getFats().compareTo(sumObject.getFats()) == 0;
        boolean isEqualStarches = getStarches().compareTo(sumObject.getStarches()) == 0;

        return isEqualCal && isEqualProteins && isEqualFats && isEqualStarches;

    }

    @Override
    public int hashCode() {

        return Objects.hash(getCalories(), getProteins(), getFats(), getStarches());
    }
}

package com.jay.calories_calculator.model.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Length(min = 3, max = 50, message = "Name of the food must be between 3 and 50 characters")
    @NotEmpty(message = "Name of the food cant be empty")
    private String name;

    @Column
    @Max(value = 9999)
    private Integer cal;

    @Column
    @DecimalMin(value = "0", message = "This field must be from 0 to 9999.9")
    @DecimalMax(value = "9999.9", message = "This field must be from 0 to 9999.9")
    private Double protein;

    @Column
    @DecimalMin(value = "0", message = "This field must be from 0 to 9999.9")
    @DecimalMax(value = "9999.9", message = "This field must be from 0 to 9999.9")
    private Double starches;

    @Column
    @DecimalMin(value = "0", message = "This field must be from 0 to 9999.9")
    @DecimalMax(value = "9999.9", message = "This field must be from 0 to 9999.9")
    private Double fats;

    public Food() {
    }

    public Food(String name, Integer cal, Double protein, Double starches, Double fats) {
        this.name = name;
        this.cal = cal;
        this.protein = protein;
        this.starches = starches;
        this.fats = fats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getStarches() {
        return starches;
    }

    public void setStarches(Double starches) {
        this.starches = starches;
    }

    public Double getFats() {
        return fats;
    }

    public void setFats(Double fats) {
        this.fats = fats;
    }


}

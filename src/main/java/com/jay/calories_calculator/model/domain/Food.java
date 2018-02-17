package com.jay.calories_calculator.model.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

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
    @DecimalMin(value = "0.0", message = "This field can't be negative")
    @DecimalMax(value = "9999.9",message = "Max value of this field can be 9999.9")
    private int cal;

    @Column
    @DecimalMin(value = "0.0", message = "This field can't be negative")
    @DecimalMax(value = "9999.9",message = "Max value of this field can be 9999.9")
    private Double protein;

    @Column
    @DecimalMin(value = "0.0", message = "This field can't be negative")
    @DecimalMax(value = "9999.9",message = "Max value of this field can be 9999.9")
    private Double starches;

    @Column
    @DecimalMin(value = "0.0", message = "This field can't be negative")
    @DecimalMax(value = "9999.9",message = "Max value of this field can be 9999.9")
    private Double fats;

    public Food() {
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

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
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

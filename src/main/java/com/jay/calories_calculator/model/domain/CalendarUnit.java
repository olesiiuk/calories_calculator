package com.jay.calories_calculator.model.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calendar")
public class CalendarUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int value;

    @Column
    private LocalDateTime date;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Column(name = "food_id", insertable = false, updatable = false)
    private Long foodId;

    @ManyToOne
    @JoinColumn(name = "food_id", nullable = false)
    private Food food;

    public CalendarUnit() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

package com.examle.web4.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Table(name = "results")

public class Result {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Max(3)
    @Min(-5)
    @Column(nullable = false)
    private double x;

    @Max(5)
    @Min(-5)
    @Column(nullable = false)
    private double y;

    @Max(5)
    @Min(1)
    @Column(nullable = false)
    private double r;

    @Column(nullable = false)
    private boolean hit;

    @Column(nullable = false)
    private String time;
    public boolean getHit() {
        return hit;
    }
}

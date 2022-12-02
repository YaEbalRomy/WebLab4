package com.examle.web4.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
@Table(name = "result")

public class Result {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Max(3)
    @Min(-5)
    @Column(nullable = false)
    private Double x;

    @Max(5)
    @Min(-5)
    @Column(nullable = false)
    private Double y;

    @Max(5)
    @Min(1)
    @Column(nullable = false)
    private Double r;

    @Column(nullable = false)
    private Boolean result;

    @Column(nullable = false)
    private String time;

}

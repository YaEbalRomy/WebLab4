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
    public Result() {}
    public Result(Double y, Double x, Double r, Boolean result, String time) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.time = time;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Max(3)
    @Min(-5)
    @Column
    private Double x;
    @Max(5)
    @Min(5)
    @Column
    private Double y;
    @Max(5)
    @Min(1)
    @Column
    private Double r;
    @Column
    private Boolean result;
    @Column
    private String time;
}

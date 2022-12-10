package com.examle.web4.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "results")
public class Result {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Min(-5)
    @Max(3)
    @Column(nullable = false)
    private double x;

    @Min(-5)
    @Max(5)
    @Column(nullable = false)
    private double y;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private double r;

    @Column(nullable = false)
    private boolean hit;

    @Column(nullable = false)
    private LocalDateTime time;

    @Column(nullable = false)
    private String ownerUsername; //TODO @ManyToOne

    public boolean getHit() {
        return hit;
    }
}

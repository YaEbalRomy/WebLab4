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
    public Result(double x, double y, double r, boolean hit, LocalDateTime time, User user) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.time = time;
        this.user = user;
    }

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public boolean getHit() {
        return hit;
    }
}

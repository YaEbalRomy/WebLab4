package com.examle.web4.repositories;

import com.examle.web4.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {}

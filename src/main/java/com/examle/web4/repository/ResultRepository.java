package com.examle.web4.repository;

import com.examle.web4.entity.Result;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface ResultRepository extends CrudRepository<Result, Long> {
    Optional<List<Result>> getByUserId(Long user_id);
    void deleteAllByUserId(Long user_id);
}

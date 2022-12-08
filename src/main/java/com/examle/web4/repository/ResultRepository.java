package com.examle.web4.repository;

import com.examle.web4.entity.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
    List<Result> getResultsByOwnerUsername(String ownerUsername);
    void deleteAllByOwnerUsername(String ownerUsername);
}

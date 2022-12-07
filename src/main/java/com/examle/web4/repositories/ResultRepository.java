package com.examle.web4.repositories;

import com.examle.web4.entityes.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
    List<Result> getResultsByOwnerUsername(String ownerUsername);
    void deleteAllByOwnerUsername(String ownerUsername);
}

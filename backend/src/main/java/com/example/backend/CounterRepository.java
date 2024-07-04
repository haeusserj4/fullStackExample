package com.example.backend;

import com.example.backend.Entities.Counter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Counter u SET u.counter = :counter WHERE u.id = :id")
    int updateCounter(@Param("id") long id, @Param("counter") long counter);
}

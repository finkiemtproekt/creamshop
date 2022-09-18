package com.ukim.mk.projectspring.repo;

import com.ukim.mk.projectspring.model.Cream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CreamRepository extends JpaRepository<Cream, Integer> {

    @Query(value ="select cream_name from Cream where cream_name=?",nativeQuery = true)
    Optional<Cream> findByName(String name);


    @Query(value ="delete from Cream where cream_name=?",nativeQuery = true)
    void deleteByName(String name);
}
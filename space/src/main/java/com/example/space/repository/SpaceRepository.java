package com.example.space.repository;


import com.example.space.model.entity.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface SpaceRepository extends CrudRepository<Space,Long> {
}

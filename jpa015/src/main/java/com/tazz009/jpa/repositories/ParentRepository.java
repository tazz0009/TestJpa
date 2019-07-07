package com.tazz009.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Parent;

public interface ParentRepository extends JpaRepository<Parent, Long> {

	Optional<Parent> findById1AndId2(String id1, String id2);

}

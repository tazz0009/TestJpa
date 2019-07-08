package com.tazz009.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.entities.ParentId;

public interface ParentRepository extends JpaRepository<Parent, ParentId> {

	Optional<Parent> findById(ParentId parentId);

}

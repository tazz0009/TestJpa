package com.tazz009.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.GrandChild;
import com.tazz009.jpa.entities.GrandChildId;

public interface GrandChildRepository extends JpaRepository<GrandChild, GrandChildId> {

	Optional<GrandChild> findByChildAndId(Child child, String id);

}

package com.tazz009.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.GrandChild;

public interface GrandChildRepository extends JpaRepository<GrandChild, String> {

	Optional<GrandChild> findByChildAndId(Child child, String id);

}

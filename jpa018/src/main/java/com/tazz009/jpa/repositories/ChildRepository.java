package com.tazz009.jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.ChildId;
import com.tazz009.jpa.entities.Parent;

public interface ChildRepository extends JpaRepository<Child, ChildId> {

	Optional<Child> findByParentAndChildId(Parent parent, String childId);

	List<Child> findByParent(Parent parent);

}

package com.tazz009.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.Parent;

public interface ChildRepository extends JpaRepository<Child, Long> {

//	List<Child> findByParent(Parent parent);

}

package com.tazz009.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Locker;

public interface LockerRepository extends JpaRepository<Locker, String> {

	Locker findByName(String name);

}

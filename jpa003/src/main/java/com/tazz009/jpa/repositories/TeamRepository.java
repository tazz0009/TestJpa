package com.tazz009.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Team;

public interface TeamRepository extends JpaRepository<Team, String> {

}
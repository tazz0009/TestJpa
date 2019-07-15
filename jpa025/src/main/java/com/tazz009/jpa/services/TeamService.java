package com.tazz009.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public Team save(Team team) {
		return teamRepository.save(team);
	}

	public Optional<Team> findById(Team team) {
		return teamRepository.findById(team.getId());
	}
	
}

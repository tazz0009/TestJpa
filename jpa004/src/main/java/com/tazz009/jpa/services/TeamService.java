package com.tazz009.jpa.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public void deleteAll() {
		teamRepository.deleteAll();
	}

	public Team save(Team team) {
		return teamRepository.save(team);
	}
	
	public Optional<Team> findOne(String id) {
		return teamRepository.findById(id);
	}
	
}

package com.tazz009.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.GrandChild;
import com.tazz009.jpa.repositories.GrandChildRepository;

@Service
public class GrandChildService {

	@Autowired
	private GrandChildRepository grandChildRepository;

	public GrandChild save(GrandChild grandChild) {
		return grandChildRepository.save(grandChild);
	}

	public Optional<GrandChild> find(GrandChild grandChild) {
		return grandChildRepository.findByChildAndId(grandChild.getChild(), grandChild.getId());
	}

}

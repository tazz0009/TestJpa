package com.tazz009.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.GrandChild;
import com.tazz009.jpa.entities.GrandChildId;
import com.tazz009.jpa.repositories.GrandChildRepository;

@Service
public class GrandChildService {

	@Autowired
	private GrandChildRepository grandChildRepository;

	public GrandChild save(GrandChild grandChild) {
		return grandChildRepository.save(grandChild);
	}

	public Optional<GrandChild> findById(GrandChildId grandChildId) {
		return grandChildRepository.findById(grandChildId);
	}

	public List<GrandChild> findByChild(Child child) {
		return grandChildRepository.findByChild(child);
	}

}

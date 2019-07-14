package com.tazz009.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.repositories.ChildRepository;

@Service
public class ChildService {

	@Autowired
	private ChildRepository childRepository;

	public Child save(Child child) {
		return childRepository.save(child);
	}

}

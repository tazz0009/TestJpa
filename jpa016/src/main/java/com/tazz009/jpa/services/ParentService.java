package com.tazz009.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.entities.ParentId;
import com.tazz009.jpa.repositories.ParentRepository;

@Service
public class ParentService {

	@Autowired
	private ParentRepository parentRepository;

	public Parent save(Parent parent) {
		return parentRepository.save(parent);
	}

	public Optional<Parent> findById(ParentId parentId) {
		return parentRepository.findById(parentId);
	}

}

package com.tazz009.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.repositories.GrandChildRepository;

@Service
public class GrandChildService {

	@Autowired
	private GrandChildRepository grandChildRepository;
	
}

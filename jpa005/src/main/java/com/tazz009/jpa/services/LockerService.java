package com.tazz009.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Locker;
import com.tazz009.jpa.repositories.LockerRepository;

@Service
public class LockerService {

	@Autowired
	private LockerRepository lockerRepository;

	public Locker save(Locker locker) {
		return lockerRepository.save(locker);
	}

	public Locker findByName(String name) {
		return lockerRepository.findByName(name);
	}

	public void deleteAll() {
		lockerRepository.deleteAll();
	}
	
}

package com.tazz009.jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Item;
import com.tazz009.jpa.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item save(Item album) {
		return itemRepository.save(album);
	}
	
	
	
}

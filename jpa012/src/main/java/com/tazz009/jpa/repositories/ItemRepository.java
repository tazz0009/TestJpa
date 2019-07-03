package com.tazz009.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}

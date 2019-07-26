package com.tazz009.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Order;
import com.tazz009.jpa.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public Order save(Order order) {
		return orderRepository.save(order);
	}

	public List<Order> findAll(Sort sort) {
		return orderRepository.findAll(sort);
	}

	public List<Order> findByMember(String memberId, Sort sort) {
		return orderRepository.findByMemberId(memberId, sort);
	}
	
}

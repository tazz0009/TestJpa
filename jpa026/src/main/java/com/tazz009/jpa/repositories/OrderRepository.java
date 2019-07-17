package com.tazz009.jpa.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByMemberId(String memberId, Sort sort);

	List<Order> findByProductId(String productId, Sort sort);

}

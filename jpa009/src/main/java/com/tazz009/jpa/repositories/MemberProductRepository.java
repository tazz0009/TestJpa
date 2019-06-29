package com.tazz009.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.MemberProduct;

public interface MemberProductRepository extends JpaRepository<MemberProduct, String> {

	MemberProduct findByMemberIdAndProductId(String memberId, String productId);

	List<MemberProduct> findByMemberId(String memberId);

}

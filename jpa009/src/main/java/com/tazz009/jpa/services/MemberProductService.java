package com.tazz009.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.MemberProduct;
import com.tazz009.jpa.entities.MemberProductId;
import com.tazz009.jpa.repositories.MemberProductRepository;

@Service
public class MemberProductService {
	
	@Autowired
	private MemberProductRepository memberProductRepository;

	public MemberProduct save(MemberProduct memberProduct) {
		return memberProductRepository.save(memberProduct);
	}

	public MemberProduct findByMemberIdAndProductId(String memberId, String productId) {
		return memberProductRepository.findByMemberIdAndProductId(memberId, productId);
	}

	public List<MemberProduct> findByMemberId(String memberId) {
		return memberProductRepository.findByMemberId(memberId);
	}
}

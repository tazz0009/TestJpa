package com.tazz009.jpa.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.repositories.MemberRepository;
import com.tazz009.jpa.repositories.ProductRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ProductRepository productRepository;
	
	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public void deleteAll() {
		memberRepository.deleteAll();
	}

	public Member save(Member member, String[] productIds) {
		if (productIds != null && productIds.length > 0) {
			for (String productId : productIds) {
				member.addProduct(productRepository.findById(productId));
			}
		}
		return memberRepository.save(member);
	}

	public Optional<Member> findById(String id) {
		return memberRepository.findById(id);
	}
	
}

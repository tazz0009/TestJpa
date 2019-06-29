package com.tazz009.jpa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.repositories.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public void deleteAll() {
		memberRepository.deleteAll();
	}

	public Optional<Member> findById(String id) {
		return memberRepository.findById(id);
	}
	
}

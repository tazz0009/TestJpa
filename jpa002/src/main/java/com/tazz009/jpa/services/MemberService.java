package com.tazz009.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.repositories.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public void deleteAll() {
		memberRepository.deleteAll();
	}

	public void save(Member member) {
		memberRepository.save(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	public void deleteMember(Member member) {
		memberRepository.deleteById(member.getId());
	}

	public Optional<Member> findMember(Member member) {
		return memberRepository.findById(member.getId());
	}
}

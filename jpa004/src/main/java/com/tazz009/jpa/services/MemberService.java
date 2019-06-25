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

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}
	
	public Optional<Member> findMember(String id) {
		return memberRepository.findById(id);
	}
	
	public List<Member> findAllByTeamname(String teamname) {
		return memberRepository.findAllByTeamname(teamname);
	}
	
}

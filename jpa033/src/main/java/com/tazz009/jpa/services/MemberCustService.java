package com.tazz009.jpa.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.repositories.MemberCustRepositoryImpl;

@Service
@Transactional
public class MemberCustService {

	@Autowired
	private MemberCustRepositoryImpl memberCustRepository;

	public List<Member> findMemberWithInnerJoin(String teamName) {
		return memberCustRepository.findMemberWithInnerJoin(teamName);
	}

	public List<Object[]> findMemberWithInnerJoin2(String teamName) {
		return memberCustRepository.findMemberWithInnerJoin2(teamName);
	}

	public List<Member> findMemberWithOuterJoin(String teamName) {
		return memberCustRepository.findMemberWithOuterJoin(teamName);
	}

	public List<Member> findMemberWithFetchJoin(String teamName) {
		return memberCustRepository.findMemberWithFetchJoin(teamName);
	}
	
}

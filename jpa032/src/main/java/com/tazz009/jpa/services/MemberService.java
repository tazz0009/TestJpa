package com.tazz009.jpa.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.repositories.MemberRepositoryImpl;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepositoryImpl memberRepository;

	public Member save(Member member) {
		return memberRepository.save(member);
	}

	public List<Member> findAllByTypedQuery() {
		return memberRepository.findAllByTypedQuery();
	}

	@SuppressWarnings("rawtypes")
	public List findAllByQuery() {
		return memberRepository.findAllByQuery();
	}

	public List<Member> findAllByParameter(Member member) {
		return memberRepository.findAllByParameter(member);
	}

	public List<Object[]> findAllByProjection() {
		return memberRepository.findAllByProjection();
	}

	public List<Member> findAllWithPaging(int startPosition, int maxResult) {
		return memberRepository.findAllWithPaging(startPosition, maxResult);
	}

	public Object[] findAllWithAnalistic() {
		return memberRepository.findAllWithAnalistic();
	}

}

package com.tazz009.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tazz009.jpa.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	@Query("select m from Member m join m.team t where t.name = ?1")
	List<Member> findAllByTeamname(String teamname);
	
}
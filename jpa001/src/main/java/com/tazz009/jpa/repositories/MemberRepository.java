package com.tazz009.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tazz009.jpa.entities.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}

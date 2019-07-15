package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa025ApplicationTests {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	@After
	public void after() {
	}
	
//	@Test
//	public void testA_SAVE_Team() throws Exception {
//		Team team1 = Team.builder()
//				.name("team1")
//				.build();
//		Team savedTeam1 = teamService.save(team1);
//		
//		assertThat(savedTeam1.getId(), is(1L));
//		assertThat(savedTeam1.getName(), is(team1.getName()));
//	}
//
//	@Test
//	public void testB_SAVE_Member() throws Exception {
//		Team team1 = Team.builder()
//				.id(1L)
//				.build();
//		Optional<Team> finedTeam1 = teamService.findById(team1);
//		
//		Member member1 = Member.builder()
//				.username("member1")
//				.team(team1)
//				.build();
//		Member savedMember1 = memberService.save(member1);
//		
//		assertThat(savedMember1.getUsername(), is(member1.getUsername()));
////		error???? savedMember1.getTeam() == null
////		assertThat(savedMember1.getTeam().getName(), is(finedTeam1.get().getName()));
//	}

	@Test
//	@Transactional
	public void testC_FIND_Member() throws Exception {
		Member member1 = Member.builder()
				.id(2L)
				.build();
		System.out.println("--1");
		Optional<Member> findedMember1 = memberService.findById(member1);
		System.out.println("--2");
		Team team = findedMember1.get().getTeam();
		System.out.println("--3");
		
		assertThat(findedMember1.get().getUsername(), is("member1"));
		assertThat(team.getName(), is("team1"));
	}
}

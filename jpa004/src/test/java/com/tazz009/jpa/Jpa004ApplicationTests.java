package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa004ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TeamService teamService;
	
	@Before
	public void before() {
//		memberService.deleteAll();
//		teamService.deleteAll();
	}

	@After
	public void after() {
//		memberService.deleteAll();
//		teamService.deleteAll();
	}
	
	@Test
	@Transactional
	public void test001() {
		// 1. 저장
		Team team1 = Team.builder()
				.id("team1")
				.name("팀1")
				.build();
		
		Team savedTeam1 = teamService.save(team1);
		
		Member member1 = Member.builder()
				.id("member1")
				.username("회원1")
				.team(savedTeam1)
				.build();
		Member savedMember1 = memberService.save(member1);

		assertThat(savedMember1.getId(), is(member1.getId()));
		assertThat(savedMember1.getUsername(), is(member1.getUsername()));
		assertThat(savedMember1.getTeam().getId(), is(member1.getTeam().getId()));
		
		Member member2 = Member.builder()
				.id("member2")
				.username("회원2")
				.team(savedTeam1)
				.build();
		Member savedMember2 = memberService.save(member2);
		
		assertThat(savedMember2.getId(), is(member2.getId()));
		assertThat(savedMember2.getUsername(), is(member2.getUsername()));
		assertThat(savedMember2.getTeam().getId(), is(member2.getTeam().getId()));
		
		// 2. 조회 MEMBER
		Optional<Member> findMember1 = memberService.findMember(savedMember1.getId());
		assertThat(savedMember1.getId(), is(findMember1.get().getId()));
		assertThat(savedMember1.getUsername(), is(findMember1.get().getUsername()));
		assertThat(savedMember1.getTeam().getId(), is(findMember1.get().getTeam().getId()));
		
		List<Member> findedMembers = memberService.findAllByTeamname(savedTeam1.getName());
		assertThat(findedMembers.size(), is(2));
		
		
		// 3. 조회 TEAM 
		Optional<Team> findedTeam = teamService.findOne(savedTeam1.getId());

		// 4. TEAM에 속한 MEMBER 확인
		List<Member> members = findedTeam.get().getMembers();
		for (Member member : members) {
			System.out.println(member.getUsername());
		}
	}

}

package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

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
public class Jpa003ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private TeamService teamService;
	
	@Before
	public void before() {
		memberService.deleteAll();
		teamService.deleteAll();
	}

	@After
	public void after() {
//		memberService.deleteAll();
	}
	
	@Test
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
		
		// 2. 조회
		Optional<Member> findMember1 = memberService.findMember(savedMember1.getId());
		assertThat(savedMember1.getId(), is(findMember1.get().getId()));
		assertThat(savedMember1.getUsername(), is(findMember1.get().getUsername()));
		assertThat(savedMember1.getTeam().getId(), is(findMember1.get().getTeam().getId()));
		
		List<Member> findedMembers = memberService.findAllByTeamname(savedTeam1.getName());
		assertThat(findedMembers.size(), is(2));
		for (Member member : findedMembers) {
			System.out.println(member.toString());
		}
		
		// 3. 수정
		Team team2 = Team.builder()
				.id("team2")
				.name("팀2")
				.build();
		
		Team savedTeam2 = teamService.save(team2);
		member1.setTeam(team2);
		memberService.save(member1);
		
		Optional<Member> findMember = memberService.findMember(member1.getId());
		assertThat(member1.getId(), is(findMember.get().getId()));
		assertThat(member1.getUsername(), is(findMember.get().getUsername()));
		assertThat(member1.getTeam().getId(), is(findMember.get().getTeam().getId()));
		
		// 4. 연관관계 제거
		List<Member> findedMembers2 = memberService.findAllByTeamname(savedTeam1.getName());
		for (Member member : findedMembers2) {
			member.setTeam(null);
			memberService.save(member);
		}
		
	}
}

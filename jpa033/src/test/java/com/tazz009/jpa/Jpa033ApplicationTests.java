package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.services.MemberCustService;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa033ApplicationTests {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberCustService memberCustService;
	
//	@Test
//	public void testA_SAVE_Team() throws Exception {
//		Team team1 = Team.builder()
//				.name("teamA")
//				.build();
//		Team savedTeam1 = teamService.save(team1);
//		
//		assertThat(savedTeam1.getId(), is(1L));
//		assertThat(savedTeam1.getName(), is(team1.getName()));
//
//		Team team2 = Team.builder()
//				.name("teamB")
//				.build();
//		Team savedTeam2 = teamService.save(team2);
//
//		assertThat(savedTeam2.getId(), is(2L));
//		assertThat(savedTeam2.getName(), is(team2.getName()));
//	}
//
//	@Test
//	public void testB_SAVE_Member() throws Exception {
//		Team team1 = Team.builder()
//				.id(1l)
//				.build();
//		Optional<Team> finedTeam1 = teamService.findById(team1);
//
//		Team team2 = Team.builder()
//				.id(2l)
//				.build();
//		Optional<Team> finedTeam2 = teamService.findById(team2);
//		
//		Member member1 = Member.builder()
//				.username("memberA")
//				.team(team1)
//				.age(15)
//				.build();
//		Member savedMember1 = memberService.save(member1);
//		
//		Member member2 = Member.builder()
//				.username("memberB")
//				.team(team1)
//				.age(25)
//				.build();
//		Member savedMember2 = memberService.save(member2);
//		
//		Member member3 = Member.builder()
//				.username("memberC")
//				.team(team1)
//				.age(5)
//				.build();
//		Member savedMember3 = memberService.save(member3);
//		
//		Member member4 = Member.builder()
//				.username("memberD")
//				.team(team2)
//				.age(51)
//				.build();
//		Member savedMember4 = memberService.save(member4);
//		
//		Member member5 = Member.builder()
//				.username("memberE")
//				.team(team2)
//				.age(31)
//				.build();
//		Member savedMember5 = memberService.save(member5);
//
//		Member member6 = Member.builder()
//				.username("memberF")
//				.age(34)
//				.build();
//		Member savedMember6 = memberService.save(member6);
//		
//	}
	
	@Test
	@Transactional
	public void testC_FindWithInnerJoin_Member() throws Exception {
		String teamName = "teamA";
		List<Member> listMember = memberCustService.findMemberWithInnerJoin(teamName);
		
		for (Member member : listMember) {
			System.out.println(ToStringBuilder.reflectionToString(member, ToStringStyle.DEFAULT_STYLE));
		}
		assertThat(listMember.size(), is(3));
	}

	@Test
	public void testD_FindWithInnerJoin2_Member() throws Exception {
		String teamName = "teamA";
		List<Object[]> listMember = memberCustService.findMemberWithInnerJoin2(teamName);
		
		for (Object[] row: listMember) {
			String username = (String) row[0];
			String teamname = (String) row[1];
			System.out.println(username + " , " + teamname);
		}
		
		assertThat(listMember.size(), is(3));
	}

	@Test
	@Transactional
	public void testE_FindWithOuterJoin_Member() throws Exception {
		String teamName = "teamA";
		List<Member> listMember = memberCustService.findMemberWithOuterJoin(teamName);
		
//		for (Member member : listMember) {
//			System.out.println(ToStringBuilder.reflectionToString(member, ToStringStyle.DEFAULT_STYLE));
//			System.out.println(member.getTeam().getName());
//		}
		assertThat(listMember.size(), is(6));
	}

	@Test
	public void testF_FindWithFetchJoin_Member() throws Exception {
		String teamName = "teamA";
		List<Member> listMember = memberCustService.findMemberWithFetchJoin(teamName);
//	select
//        member0_.member_id as member_i1_0_0_,
//        team1_.team_id as team_id1_3_1_,
//        member0_.age as age2_0_0_,
//        member0_.team_team_id as team_tea4_0_0_,
//        member0_.username as username3_0_0_,
//        team1_.name as name2_3_1_ 
//    from
//        member member0_ 
//    inner join
//        team team1_ 
//            on member0_.team_team_id=team1_.team_id		
		for (Member member : listMember) {
			System.out.println(ToStringBuilder.reflectionToString(member, ToStringStyle.DEFAULT_STYLE));
			System.out.println(member.getTeam().getName());
		}
		assertThat(listMember.size(), is(5));
	}
	
	
}

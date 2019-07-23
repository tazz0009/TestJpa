package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.services.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa032ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testA_SAVE_Members() throws Exception {
		Member member1 = Member.builder()
				.name("member1")
				.age(20)
				.build();
		Member savedMember1 = memberService.save(member1);
		
		Member member2 = Member.builder()
				.name("member2")
				.age(30)
				.build();
		Member savedMember2 = memberService.save(member2);
		
		assertThat(savedMember1.getId(), is(1l));
		assertThat(savedMember2.getId(), is(2l));
	}

	@Test
	public void testB_FIND_ByTypedQuery_Members() throws Exception {
		List<Member> listMember = memberService.findAllByTypedQuery();
		
		assertThat(listMember.size(), is(2));
		assertThat(listMember.get(0).getId(), is(1l));
		assertThat(listMember.get(1).getId(), is(2l));
	}
	
	@Test
	public void testC_FIND_ByQuery_Members() throws Exception {
		@SuppressWarnings("rawtypes")
		List listMember = memberService.findAllByQuery();
		
		assertThat(listMember.size(), is(2));
		assertThat(((Member) listMember.get(0)).getId(), is(1l));
		assertThat(((Member) listMember.get(1)).getId(), is(2l));
	}
	
	@Test
	public void testD_FIND_WithParameter_Members() throws Exception {
		Member member1 = Member.builder()
				.name("member1")
				.build();
		List<Member> listMember = memberService.findAllByParameter(member1);
		
		assertThat(listMember.size(), is(1));
		assertThat(listMember.get(0).getId(), is(1l));
	}
	
	@Test
	public void testF_FIND_WithProjection_Members() throws Exception {
		List<Object[]> listMember = memberService.findAllByProjection();
		
		assertThat(listMember.size(), is(2));
		assertThat(listMember.get(0)[0], is("member1"));
		assertThat(listMember.get(0)[1], is(20));
		assertThat(listMember.get(1)[0], is("member2"));
		assertThat(listMember.get(1)[1], is(30));
	}
	
	@Test
	public void testG_FIND_WithPaging_Members() throws Exception {
		int startPosition = 0;
		int maxResult = 10;
		List<Member> listMember = memberService.findAllWithPaging(startPosition, maxResult);
		
		assertThat(listMember.size(), is(2));
		assertThat(listMember.get(0).getId(), is(1l));
		assertThat(listMember.get(1).getId(), is(2l));
//		Hibernate: 
//		    select
//		        member0_.id as id1_0_,
//		        member0_.age as age2_0_,
//		        member0_.name as name3_0_ 
//		    from
//		        member member0_ limit ?
	}
	
	@Test
	public void testH_FIND_WithAnalistic_Members() throws Exception {
		Object[] result = memberService.findAllWithAnalistic();
		
		assertThat(result[0], is(2l));
		assertThat(result[1], is(50l));
		assertThat(result[2], is(25.0));
		assertThat(result[3], is(30));
		assertThat(result[4], is(20));
	}
	
}

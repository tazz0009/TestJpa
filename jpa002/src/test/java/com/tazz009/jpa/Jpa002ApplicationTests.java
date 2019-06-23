package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
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
import com.tazz009.jpa.entities.RoleType;
import com.tazz009.jpa.services.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa002ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Before
	public void before() {
		memberService.deleteAll();
	}
	
	@After
	public void after() {
//		memberService.deleteAll();
	}
	
	@Test
	public void test001() {
		String id = "test001";
		String username = "testtuser";
		Integer age = 19;
		RoleType roleType = RoleType.USER;
		String description = "desc1";
		
		// create entity 
		Member member1 = Member.builder()
				.id(id)
				.username(username)
				.age(age)
				.roleType(roleType)
				.description(description)
				.createdDate(new Date())
				.lastModifiedDate(new Date())
				.build();
		
		// save entity 
		memberService.save(member1);
		
		// find entities 
		List<Member> findAll = memberService.findAll();
		
		// find entity 
		Member member = findAll.get(0);
		
		// check save entity
		assertThat(member.getId(), is(id));
		assertThat(member.getUsername(), is(username));
		assertThat(member.getAge(), is(age));
		assertThat(member.getRoleType(), is(roleType));
		assertThat(member.getDescription(), is(description));

		// update entity
		member.setUsername("testuser2");
		member.setRoleType(RoleType.ADMIN);
		member.setDescription("desc2");
		memberService.save(member);
		
		// find entities 
		findAll = memberService.findAll();
		
		// find entity 
		Member member2 = findAll.get(0);
		
		// check update entity
		assertThat(member2.getId(), is(id));
		assertThat(member2.getUsername(), is("testuser2"));
		assertThat(member2.getAge(), is(age));
		
//		// delete entity
//		memberService.deleteMember(member2);
//		
//		// find entity
//		Optional<Member> findMember = memberService.findMember(member2);
//		
//		// check delete entity
//		assertThat(findMember.isEmpty(), is(true));
	}

}

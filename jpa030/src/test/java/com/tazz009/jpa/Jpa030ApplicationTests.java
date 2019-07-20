package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Address;
import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.services.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa030ApplicationTests {

	@Autowired
	private MemberService memberService;
	
//	@Test
//	public void testA_mutable() throws Exception {
//		Address homeAddress = Address.builder()
//			.city("OldCity")
//			.street("bigway")
//			.zipcode("00100").build();
//
//		Member member1 = Member.builder()
//				.name("tazz009")
//				.homeAddress(homeAddress)
//				.build();
//		Member savedMember1 = memberService.save(member1);
//		
//		Address homeAddress2 = savedMember1.getHomeAddress();
//		
//		homeAddress2.setCity("NewCity");
//		Member member2 = Member.builder()
//			.name("tazz009")
//			.homeAddress(homeAddress2)
//			.build();
//		Member savedMember2 = memberService.save(member2);
//		// DB도 변경됨
////		savedMember1 = memberService.save(member1);
//		
//		assertThat(savedMember1.getHomeAddress().getCity(), is("NewCity"));
//		assertThat(savedMember2.getHomeAddress().getCity(), is("NewCity"));
//	}
	
	@Test
	public void testB_immutable() throws Exception {
		Address homeAddress1 = Address.builder()
				.city("OldCity")
				.street("bigway")
				.zipcode("00100").build();
		
		Member member1 = Member.builder()
				.name("tazz009")
				.homeAddress(homeAddress1)
				.build();
		Member savedMember1 = memberService.save(member1);
		
		Address homeAddress2 = Address.builder()
				.city("NewCity")
				.street(homeAddress1.getStreet())
				.zipcode(homeAddress1.getZipcode()).build();
		
		Member member2 = Member.builder()
				.name("tazz009")
				.homeAddress(homeAddress2)
				.build();
		Member savedMember2 = memberService.save(member2);
		
		assertThat(savedMember1.getHomeAddress().getCity(), is("OldCity"));
		assertThat(savedMember2.getHomeAddress().getCity(), is("NewCity"));
	}

}

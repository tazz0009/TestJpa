package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Address;
import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Period;
import com.tazz009.jpa.services.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa028ApplicationTests {

	@Autowired
	private MemberService memberService;
	
//	step 2	
	@Test
	public void testA_SAVE_Member() throws Exception {
		Period period1 = Period.builder()
			.startDate(new Date())
			.endtDate(new Date()).build();
		
		Address address1 = Address.builder()
			.city("Seoul")
			.street("Street")
			.zipcode("00100").build();
			
		Member member1 = Member.builder()
				.name("tazz009")
				.workPeriod(period1)
				.homeAddress(address1).build();
		Member savedMember1 = memberService.save(member1);
		
		assertThat(savedMember1.getId(), is(1L));
	}

	@Test
	public void testB_FIND_Member() throws Exception {
		Member member1 = Member.builder()
				.id(1L).build();
		Optional<Member> finedMember1 = memberService.find(member1);
		
		assertThat(finedMember1.get().getId(), is(1L));
	}
//	step 1	
//	@Test
//	public void testA_SAVE_Member() throws Exception {
//		Member member1 = Member.builder()
//				.name("tazz009")
//				.startDate(new Date())
//				.endtDate(new Date())
//				.city("Seoul")
//				.street("Street")
//				.zipcode("00100").build();
//		Member savedMember1 = memberService.save(member1);
//		
//		assertThat(savedMember1.getId(), is(1L));
//	}
//
//	@Test
//	public void testB_FIND_Member() throws Exception {
//		Member member1 = Member.builder()
//				.id(1L).build();
//		Optional<Member> finedMember1 = memberService.find(member1);
//		
//		assertThat(finedMember1.get().getId(), is(1L));
//	}

}

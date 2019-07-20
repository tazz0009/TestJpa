package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

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
public class Jpa029ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testA_SAVE_Member() throws Exception {
		Address homeAddress = Address.builder()
			.city("Seoul")
			.street("bigway")
			.zipcode("00100").build();

		Address companyAddress = Address.builder()
				.city("Seoul")
				.street("smallway")
				.zipcode("00200").build();
			
		Member member1 = Member.builder()
				.name("tazz009")
				.homeAddress(homeAddress)
				.companyAddress(companyAddress)
				.build();
		Member savedMember1 = memberService.save(member1);
		
		assertThat(savedMember1.getId(), is(1L));
	}

}

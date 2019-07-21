package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

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
public class Jpa031ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Test
	public void testA_SAVE_Member() throws Exception {
		Address homeAddress = Address.builder()
			.city("OldCity")
			.street("bigway")
			.zipcode("00100").build();

		Member member1 = Member.builder()
				.name("tazz009")
				.homeAddress(homeAddress)
				.build();
		member1.getFavoriteFoods().add("짬뽕");
		member1.getFavoriteFoods().add("짜장");
		member1.getFavoriteFoods().add("탕수육");
		
		Address address1 = Address.builder()
				.city("City1")
				.street("Way1")
				.zipcode("00001").build();
		Address address2 = Address.builder()
				.city("City2")
				.street("Way2")
				.zipcode("00002").build();
		Address address3 = Address.builder()
				.city("City3")
				.street("Way3")
				.zipcode("00003").build();
		
		member1.getAddressHistory().add(address1);
		member1.getAddressHistory().add(address2);
		member1.getAddressHistory().add(address3);
		
		Member savedMember1 = memberService.save(member1);
	}
	
	@Test
	@Transactional
	public void testB_FIND_Member() throws Exception {
		Member member1 = Member.builder()
				.id(1l).build();

		Optional<Member> findedMemeber1 = memberService.find(member1);
		
		assertThat(findedMemeber1.get().getId(), is(member1.getId()));
		assertThat(findedMemeber1.get().getName(), is("tazz009"));
		assertThat(findedMemeber1.get().getFavoriteFoods().size(), is(3));
		assertThat(findedMemeber1.get().getAddressHistory().size(), is(3));
	}

	@Test
	public void testC_REMOVE_Member() throws Exception {
		
		Member member1 = Member.builder()
				.id(1l).build();

		Optional<Member> findedMemeber1 = memberService.find(member1);
		memberService.delete(findedMemeber1.get());
		
	}
	
}

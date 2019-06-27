package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Locker;
import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.services.LockerService;
import com.tazz009.jpa.services.MemberService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa006ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LockerService lockerService;

	@Before
	public void before() {
	}
	
	@After
	public void after() {
		memberService.deleteAll();
		lockerService.deleteAll();
	}
	
	@Test
	public void test001() {
		Locker locker1 = Locker.builder()
				.name("locker1").build();
		Locker savedlocker1 = lockerService.save(locker1);
		Locker locker2 = Locker.builder()
				.name("locker2").build();
		Locker savedlocker2 = lockerService.save(locker2);
		
		Member member1 = Member.builder().username("member1").build();
		Member savedMember1 = memberService.save(member1);
		Member member2 = Member.builder().username("member2").build();
		Member savedMember2 = memberService.save(member2);
		
		savedMember1.setLocker(savedlocker1);
		savedMember2.setLocker(savedlocker2);
		
		savedMember1 = memberService.save(savedMember1);
		assertThat(savedMember1.getUsername(), is(member1.getUsername()));
		assertThat(savedMember1.getLocker().getName(), is(savedlocker1.getName()));

		savedMember2 = memberService.save(savedMember2);
		assertThat(savedMember2.getUsername(), is(member2.getUsername()));
		assertThat(savedMember2.getLocker().getName(), is(savedlocker2.getName()));
		
		Locker findedLocker1 = lockerService.findByName(savedlocker1.getName());
		assertThat(findedLocker1.getMember().getUsername(), is(savedMember1.getUsername()));
		
		Locker findedLocker2 = lockerService.findByName(savedlocker2.getName());
		assertThat(findedLocker2.getMember().getUsername(), is(savedMember2.getUsername()));
		
	}

}

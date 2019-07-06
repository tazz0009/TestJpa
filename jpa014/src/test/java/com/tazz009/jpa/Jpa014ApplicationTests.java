package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Seller;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.SellerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa014ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private SellerService sellerService;
	
	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}

	@Test
	public void testA_SAVE_Member() throws Exception {
		Member member1 = Member.builder()
				.name("회원1")
				.email("member1@test.com")
				.build();
		Member savedMmember1 = memberService.save(member1);
		assertThat(savedMmember1.getName(), is(member1.getName()));
		assertThat(savedMmember1.getEmail(), is(member1.getEmail()));
	}

	@Test
	public void testA_SAVE_Seller() throws Exception {
		Seller seller1 = Seller.builder()
				.name("회원1")
				.shopName("상점1")
				.build();
		Seller savedSeller1 = sellerService.save(seller1);
		assertThat(savedSeller1.getName(), is(seller1.getName()));
		assertThat(savedSeller1.getShopName(), is(seller1.getShopName()));
	}
}

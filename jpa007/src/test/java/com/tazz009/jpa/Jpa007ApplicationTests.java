package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

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
import com.tazz009.jpa.entities.Product;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa007ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;

	@Before
	public void before() {
	}
	
	@After
	public void after() {
//		memberService.deleteAll();
//		productService.deleteAll();
	}
	
	@Test
	public void testA_SAVE() throws Exception {
		Product productA = Product.builder().id("productA").name("상품A").build();
		Product savedProdcutA = productService.save(productA);
		Product productB = Product.builder().id("productB").name("상품B").build();
		Product savedProdcutB = productService.save(productB);
		String[] productIds = {savedProdcutA.getId(), savedProdcutB.getId()};
		
		Member member1 = Member.builder().id("member1").username("회원1").build();
		Member savedMember = memberService.save(member1, productIds);
		assertThat(savedMember.getId(), is(member1.getId()));
		assertThat(savedMember.getUsername(), is(member1.getUsername()));
		assertThat(savedMember.getProducts().size(), is(2));
		
	}
	
	@Test
//	@Transactional
	public void testB_FIND() throws Exception {
		Member member1 = Member.builder().id("member1").username("회원1").build();
		Optional<Member> findedMember = memberService.findById(member1.getId());
		
		assertThat(findedMember.get().getId(), is(member1.getId()));
		assertThat(findedMember.get().getUsername(), is(member1.getUsername()));
		assertThat(findedMember.get().getProducts().size(), is(2));
	}
	
}

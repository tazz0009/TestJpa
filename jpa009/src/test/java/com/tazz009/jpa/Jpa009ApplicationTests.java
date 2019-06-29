package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

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
import com.tazz009.jpa.entities.MemberProduct;
import com.tazz009.jpa.entities.MemberProductId;
import com.tazz009.jpa.entities.Product;
import com.tazz009.jpa.services.MemberProductService;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa009ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberProductService memberProductService;

	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}
	
	@Test
	public void testA_SAVE() throws Exception {
		// 회원저장
		Member member1 = Member.builder().id("member1").username("회원1").build();
		Member savedMemeber1 = memberService.save(member1);
		
		// 상품저장
		Product product1 = Product.builder().id("product1").name("상품1").build();
		Product savedProduct1 = productService.save(product1);
		
		// 회원상품 저장
		MemberProduct memberProduct = new MemberProduct();
		memberProduct.setMember(savedMemeber1);
		memberProduct.setProduct(savedProduct1);
		memberProduct.setOrderAmount(2);

		MemberProduct savedMemberProduct = memberProductService.save(memberProduct);

		// 상품저장2
		Product product2 = Product.builder().id("product2").name("상품2").build();
		Product savedProduct2 = productService.save(product2);
		
		// 회원상품 저장2
		MemberProduct memberProduct2 = new MemberProduct();
		memberProduct2.setMember(savedMemeber1);
		memberProduct2.setProduct(savedProduct2);
		memberProduct2.setOrderAmount(4);
		
		savedMemberProduct = memberProductService.save(memberProduct2);
	}
	
	@Test
	public void testB_FIND() throws Exception {
		MemberProductId memberProductId = new MemberProductId();
		memberProductId.setMember("member1");
		memberProductId.setProduct("product1");
		MemberProduct memberProduct = memberProductService.findByMemberIdAndProductId(memberProductId.getMember(), memberProductId.getProduct());
		Member member = memberProduct.getMember();
		Product product = memberProduct.getProduct();
		int orderAmount = memberProduct.getOrderAmount();
		
		assertThat(member.getId(), is("member1"));
		assertThat(member.getUsername(), is("회원1"));
		assertThat(product.getId(), is("product1"));
		assertThat(product.getName(), is("상품1"));
		assertThat(orderAmount, is(2));
	}

	@Test
	public void testC_FIND() throws Exception {
		Member member1 = Member.builder().id("member1").username("회원1").build();
		Optional<Member> findedMember = memberService.findById(member1.getId());
		List<MemberProduct> memberProduct = memberProductService.findByMemberId(findedMember.get().getId());
		Member member = memberProduct.get(0).getMember();
		Product product = memberProduct.get(0).getProduct();
		int orderAmount = memberProduct.get(0).getOrderAmount();
		 
		assertThat(member.getId(), is("member1"));
		assertThat(member.getUsername(), is("회원1"));
		assertThat(product.getId(), is("product1"));
		assertThat(product.getName(), is("상품1"));
		assertThat(orderAmount, is(2));
		
		member = memberProduct.get(1).getMember();
		product = memberProduct.get(1).getProduct();
		orderAmount = memberProduct.get(1).getOrderAmount();
		 
		assertThat(member.getId(), is("member1"));
		assertThat(member.getUsername(), is("회원1"));
		assertThat(product.getId(), is("product2"));
		assertThat(product.getName(), is("상품2"));
		assertThat(orderAmount, is(4));
	}

}

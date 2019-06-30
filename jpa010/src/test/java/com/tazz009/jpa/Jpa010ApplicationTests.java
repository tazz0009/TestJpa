package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Member;
import com.tazz009.jpa.entities.Order;
import com.tazz009.jpa.entities.Product;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.OrderService;
import com.tazz009.jpa.services.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa010ApplicationTests {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;

	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}
	
	@Test
	public void testA_SAVE() throws Exception {
		// 회원 저장
		Member member1 = Member.builder()
				.id("member1")
				.username("회원1")
				.build();
		Member savedMember1 = memberService.save(member1);
		
		// 상품 저장
		Product productA = Product.builder().id("productA").name("상품1").build();
		Product savedProductA = productService.save(productA);
		Product productB = Product.builder().id("productB").name("상품2").build();
		Product savedProductB = productService.save(productB);
		
		// 주문 저장
		Order order1 = new Order();
		order1.setMember(savedMember1);
		order1.setProduct(productA);
		order1.setOrderAmount(2);
		Order savedOrder1 = orderService.save(order1);

		Order order2 = new Order();
		order2.setMember(savedMember1);
		order2.setProduct(productB);
		order2.setOrderAmount(3);
		Order savedOrder2 = orderService.save(order2);
	}
	
	@Test
	public void testB_FIND_ALL() throws Exception {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Order> findAll = orderService.findAll(sort);
		
		assertThat(findAll.get(0).getMember().getId(), is("member1"));
		assertThat(findAll.get(0).getProduct().getId(), is("productA"));
		assertThat(findAll.get(0).getOrderAmount(), is(2));

		assertThat(findAll.get(1).getMember().getId(), is("member1"));
		assertThat(findAll.get(1).getProduct().getId(), is("productB"));
		assertThat(findAll.get(1).getOrderAmount(), is(3));
	}

	@Test
	public void testC_FIND_BY_MEMBER() throws Exception {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Order> findAll = orderService.findByMember("member1", sort);
		
		assertThat(findAll.get(0).getMember().getId(), is("member1"));
		assertThat(findAll.get(0).getProduct().getId(), is("productA"));
		assertThat(findAll.get(0).getOrderAmount(), is(2));
		
		assertThat(findAll.get(1).getMember().getId(), is("member1"));
		assertThat(findAll.get(1).getProduct().getId(), is("productB"));
		assertThat(findAll.get(1).getOrderAmount(), is(3));
	}

	@Test
	public void testD_FIND_BY_PRODUCT() throws Exception {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Order> findAll = orderService.findByProduct("productA", sort);
		
		assertThat(findAll.get(0).getMember().getId(), is("member1"));
		assertThat(findAll.get(0).getProduct().getId(), is("productA"));
		assertThat(findAll.get(0).getOrderAmount(), is(2));
	}
}

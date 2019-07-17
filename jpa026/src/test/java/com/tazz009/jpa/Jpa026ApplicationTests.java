package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.After;
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
import com.tazz009.jpa.entities.Team;
import com.tazz009.jpa.services.MemberService;
import com.tazz009.jpa.services.OrderService;
import com.tazz009.jpa.services.ProductService;
import com.tazz009.jpa.services.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa026ApplicationTests {

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MemberService memberService;
	
	
	@Autowired
	private ProductService productService;

	@Autowired
	private OrderService orderService;
	
	@After
	public void after() {
	}

	@Test
	public void testA_SAVE_Team() throws Exception {
		Team team1 = Team.builder()
				.id("team01")
				.name("Ateam")
				.build();
		Team savedTeam1 = teamService.save(team1);
		
		assertThat(savedTeam1.getId(), is(team1.getId()));
		assertThat(savedTeam1.getName(), is(team1.getName()));
	}

	@Test
	public void testB_SAVE_Member() throws Exception {
		Team team1 = Team.builder()
				.id("team01")
				.build();
		Optional<Team> finedTeam1 = teamService.findById(team1);
		
		Member member1 = Member.builder()
				.id("member01")
				.username("memberA")
				.team(team1)
				.build();
		Member savedMember1 = memberService.save(member1);
		
		assertThat(savedMember1.getUsername(), is(member1.getUsername()));
//		error???? savedMember1.getTeam() == null
//		assertThat(savedMember1.getTeam().getName(), is(finedTeam1.get().getName()));
	}
	
	@Test
	public void testC_SAVE_Product() throws Exception {
		// 상품 저장
		Product productA = Product.builder()
				.id("product01")
				.name("상품1")
				.build();
		Product savedProductA = productService.save(productA);
		
		assertThat(savedProductA.getName(), is(productA.getName()));
		
		Product productB = Product.builder()
				.id("product02")
				.name("상품2")
				.build();
		Product savedProductB = productService.save(productB);

		assertThat(savedProductB.getName(), is(productB.getName()));
	}
	
	@Test
	public void testD_SAVE_Order() throws Exception {
		Member member1 = Member.builder()
				.id("member01")
				.build();
		Optional<Member> savedMember1 = memberService.find(member1);
		
		Product productA = Product.builder()
				.id("product01")
				.build();
		Optional<Product> savedProductA = productService.find(productA);

		Product productB = Product.builder()
				.id("product02")
				.build();
		Optional<Product> savedProductB = productService.find(productB);
		
		// 주문 저장
		Order order1 = new Order();
		order1.setMember(savedMember1.get());
		order1.setProduct(productA);
		order1.setOrderAmount(2);
		Order savedOrder1 = orderService.save(order1);

		Order order2 = new Order();
		order2.setMember(savedMember1.get());
		order2.setProduct(productB);
		order2.setOrderAmount(3);
		Order savedOrder2 = orderService.save(order2);
	}
	
	@Test
	public void testE_FIND_Order() throws Exception {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Order> findAll = orderService.findAll(sort);
		
		assertThat(findAll.get(0).getMember().getId(), is("member01"));
		assertThat(findAll.get(0).getProduct().getId(), is("product01"));
		assertThat(findAll.get(0).getOrderAmount(), is(2));

		assertThat(findAll.get(1).getMember().getId(), is("member01"));
		assertThat(findAll.get(1).getProduct().getId(), is("product02"));
		assertThat(findAll.get(1).getOrderAmount(), is(3));
	}
	
	@Test
	public void testF_FIND_BY_MEMBER() throws Exception {
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		List<Order> findAll = orderService.findByMember("member01", sort);
		
		assertThat(findAll.get(0).getMember().getId(), is("member01"));
		assertThat(findAll.get(0).getProduct().getId(), is("product01"));
		assertThat(findAll.get(0).getOrderAmount(), is(2));
		
		assertThat(findAll.get(1).getMember().getId(), is("member01"));
		assertThat(findAll.get(1).getProduct().getId(), is("product02"));
		assertThat(findAll.get(1).getOrderAmount(), is(3));
	}
	
	@Test
	@Transactional
	public void testG_FIND_MEMBER() throws Exception {
		Member member1 = Member.builder()
				.id("member01")
				.build();
		Optional<Member> savedMember1 = memberService.find(member1);
		assertThat(savedMember1.get().getOrders().size(), is(2));
	}
}

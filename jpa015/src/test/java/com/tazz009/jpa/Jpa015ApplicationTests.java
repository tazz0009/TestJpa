package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.entities.ParentId;
import com.tazz009.jpa.services.ChildService;
import com.tazz009.jpa.services.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa015ApplicationTests {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ChildService childService;
	
	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}

	@Test
	public void testA_SAVE_Parent() throws Exception {
		Parent parent1 = Parent.builder()
				.id1("myId1")
				.id2("myId2")
				.name("parentName")
				.build();
		
		Parent savedParent1 = parentService.save(parent1);
		
		assertThat(savedParent1.getId1(), is(parent1.getId1()));
		assertThat(savedParent1.getId2(), is(parent1.getId2()));
		assertThat(savedParent1.getName(), is(parent1.getName()));
	}
	
	@Test
	public void testB_FIND_Parent() throws Exception {
		Parent parent1 = Parent.builder()
				.id1("myId1")
				.id2("myId2")
				.build();
		Optional<Parent> finedParent1 = parentService.findById1AndId2(parent1);
		
		assertThat(finedParent1.get().getId1(), is(parent1.getId1()));
		assertThat(finedParent1.get().getId2(), is(parent1.getId2()));
		assertThat(finedParent1.get().getName(), is("parentName"));
	}

	@Test
	public void testC_SAVE_Child() throws Exception {
		Parent parent1 = Parent.builder()
				.id1("myId1")
				.id2("myId2")
				.build();
		Optional<Parent> finedParent1 = parentService.findById1AndId2(parent1);

		Child child1 = Child.builder()
				.id("child1")
				.parent(finedParent1.get())
				.build();
		Child savedChild1 = childService.save(child1);
		
		assertThat(savedChild1.getId(), is(child1.getId()));
		assertThat(savedChild1.getParent().getName(), is(finedParent1.get().getName()));
	}
	
}

package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.services.ChildService;
import com.tazz009.jpa.services.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Jpa021ApplicationTests {

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
				.name("parentName1")
				.build();
		Parent savedParent1 = parentService.save(parent1);
		
		assertThat(savedParent1.getId(), is(1L));
		assertThat(savedParent1.getName(), is(parent1.getName()));
	}

	@Test
	public void testC_SAVE_Child() throws Exception {
		Parent parent1 = Parent.builder()
				.id(1L)
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		
		Child child1 = Child.builder()
				.name("childName")
				.build();
		Child savedChild1 = childService.save(child1);
		
		finedParent1.get().setChild(savedChild1);
		
		Parent savedParent1 = parentService.save(finedParent1.get());
		
		assertThat(savedParent1.getId(), is(1L));
		assertThat(savedParent1.getName(), is("parentName1"));
		assertThat(savedParent1.getChild().getId(), is(savedChild1.getId()));
	}
}

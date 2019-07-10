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
import com.tazz009.jpa.entities.GrandChild;
import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.services.ChildService;
import com.tazz009.jpa.services.GrandChildService;
import com.tazz009.jpa.services.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa017ApplicationTests {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ChildService childService;
	
	@Autowired
	private GrandChildService grandChildService;
	
	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}

	@Test
	public void testA_SAVE_Parent() throws Exception {
		Parent parent1 = Parent.builder()
				.id("myId")
				.name("parentName")
				.build();
		
		Parent savedParent1 = parentService.save(parent1);
		
		assertThat(savedParent1.getId(), is(parent1.getId()));
		assertThat(savedParent1.getName(), is(parent1.getName()));
	}

	@Test
	public void testB_FIND_Parent() throws Exception {
		Parent parent1 = Parent.builder()
				.id("myId")
				.name("parentName")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		
		assertThat(finedParent1.get().getId(), is(parent1.getId()));
		assertThat(finedParent1.get().getName(), is("parentName"));
	}
	
	@Test
	public void testC_SAVE_Child() throws Exception {
		Parent parent1 = Parent.builder()
				.id("myId")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);

		Child child1 = Child.builder()
				.parent(finedParent1.get())
				.childId("child1")
				.name("childName")
				.build();
		Child savedChild1 = childService.save(child1);
		
		assertThat(savedChild1.getParent().getName(), is(finedParent1.get().getName()));
		assertThat(savedChild1.getChildId(), is(child1.getChildId()));
		assertThat(savedChild1.getName(), is(child1.getName()));
	}
	
	@Test
	public void testD_FIND_Child() throws Exception {
		Parent parent1 = Parent.builder()
				.id("myId")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		Child child1 = Child.builder()
				.parent(finedParent1.get())
				.childId("child1")
				.build();
		Optional<Child> savedChild1 = childService.findByParentAndId(child1);
		
		assertThat(savedChild1.get().getParent().getName(), is(finedParent1.get().getName()));
		assertThat(savedChild1.get().getChildId(), is(child1.getChildId()));
		assertThat(savedChild1.get().getName(), is("childName"));
	}
	
	@Test
	public void testE_SAVE_GrandChild() throws Exception {
		Parent parent1 = Parent.builder()
				.id("myId")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		Child child1 = Child.builder()
				.parent(finedParent1.get())
				.childId("child1")
				.build();
		Optional<Child> findedChild1 = childService.findByParentAndId(child1);
		
		GrandChild grandChild1 = GrandChild.builder()
				.child(findedChild1.get())
				.id("grandChild1")
				.name("grandChildName")
				.build();
		
		GrandChild savedGrandChild1 = grandChildService.save(grandChild1);
		
		assertThat(savedGrandChild1.getChild().getName(), is(grandChild1.getChild().getName()));
		assertThat(savedGrandChild1.getId(), is(grandChild1.getId()));
		assertThat(savedGrandChild1.getName(), is(grandChild1.getName()));
	}

	@Test
	public void testF_FIND_GrandChild() throws Exception {
		
		Parent parent1 = Parent.builder()
				.id("myId")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		Child child1 = Child.builder()
				.parent(finedParent1.get())
				.childId("child1")
				.build();
		Optional<Child> findedChild1 = childService.findByParentAndId(child1);
		
		GrandChild grandChild1 = GrandChild.builder()
				.child(findedChild1.get())
				.id("grandChild1")
				.build();
		Optional<GrandChild> findedGrandChild1 = grandChildService.find(grandChild1);
		
		assertThat(findedGrandChild1.get().getChild().getName(), is(grandChild1.getChild().getName()));
		assertThat(findedGrandChild1.get().getId(), is(grandChild1.getId()));
		assertThat(findedGrandChild1.get().getName(), is("grandChildName"));
	}
}

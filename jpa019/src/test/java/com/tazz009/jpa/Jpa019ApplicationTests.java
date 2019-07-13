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

import com.tazz009.jpa.entities.Child;
import com.tazz009.jpa.entities.Parent;
import com.tazz009.jpa.services.ChildService;
import com.tazz009.jpa.services.GrandChildService;
import com.tazz009.jpa.services.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa019ApplicationTests {

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
				.id("parentId1")
				.name("parentName1")
				.build();
		Parent savedParent1 = parentService.save(parent1);
		
		assertThat(savedParent1.getId(), is(parent1.getId()));
		assertThat(savedParent1.getName(), is(parent1.getName()));
	}

	@Test
	public void testB_FIND_Parent() throws Exception {
		Parent parent1 = Parent.builder()
				.id("parentId1")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);
		
		assertThat(finedParent1.get().getId(), is(parent1.getId()));
		assertThat(finedParent1.get().getName(), is("parentName1"));
	}
	
	@Test
	public void testC_SAVE_Child() throws Exception {
		Parent parent1 = Parent.builder()
				.id("parentId1")
				.build();
		Optional<Parent> finedParent1 = parentService.findById(parent1);

		Child child1 = Child.builder()
				.id("childId1")
				.name("childName")
				.parent(finedParent1.get())
				.build();
		Child savedChild1 = childService.save(child1);
		
		assertThat(savedChild1.getId(), is(child1.getId()));
		assertThat(savedChild1.getName(), is(child1.getName()));
		assertThat(savedChild1.getParent().getId(), is(finedParent1.get().getId()));
		assertThat(savedChild1.getParent().getName(), is(finedParent1.get().getName()));
	}
	
	@Test
	public void testD_FIND_Child() throws Exception {
		Child child1 = Child.builder()
				.id("childId1")
				.build();

		Optional<Child> findedChild1 = childService.findById(child1);
		
		assertThat(findedChild1.get().getId(), is(child1.getId()));
		assertThat(findedChild1.get().getName(), is("childName"));
		assertThat(findedChild1.get().getParent().getId(), is("parentId1"));
		assertThat(findedChild1.get().getParent().getName(), is("parentName1"));
	}

	@Test
	public void testE_FIND_Childs() throws Exception {
		Parent parent1 = Parent.builder()
				.id("parentId1")
				.build();
		
		List<Child> findedChilds1 = childService.findByParent(parent1);
		
		assertThat(findedChilds1.size(), is(1));
		assertThat(findedChilds1.get(0).getId(), is("childId1"));
		assertThat(findedChilds1.get(0).getName(), is("childName"));
		assertThat(findedChilds1.get(0).getParent().getId(), is("parentId1"));
		assertThat(findedChilds1.get(0).getParent().getName(), is("parentName1"));
	}
	
}

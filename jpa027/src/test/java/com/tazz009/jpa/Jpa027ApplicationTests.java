package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import org.junit.After;
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
import com.tazz009.jpa.services.ParentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa027ApplicationTests {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private ChildService childService;
	
	// 1. 
//	@Test
//	public void test1A_SAVE_Parent() throws Exception {
//		Parent parent = Parent.builder().build();
//		Parent savedParent = parentService.save(parent);
//		
//		Child child1 = Child.builder().parent(savedParent).build();
//		Child savedChild1 = childService.save(child1);
//	}
//
//	@Test
//	@Transactional
//	public void test1B_FIND_Child() throws Exception {
//		Child child1 = Child.builder().id(2L).build();
//		Optional<Child> findedChild1 = childService.find(child1);
//		
//		assertThat(findedChild1.get().getId(), is(child1.getId()));
//		assertThat(findedChild1.get().getParent().getId(), is(1L));
//		
//		Optional<Parent> findedParent1 = parentService.find(findedChild1.get().getParent());
//		assertThat(findedParent1.get().getChildren().get(0).getId(), is(child1.getId()));
//	}
	
	// 2. 영속성 전이:저장
	// @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
//	@Test
//	public void test2A_SAVE_Parent_Child() throws Exception {
//		Parent parent = Parent.builder().build();
//		Child child1 = Child.builder().parent(parent).build();
//		Child child2 = Child.builder().parent(parent).build();
//		parent.getChildren().add(child1);
//		parent.getChildren().add(child2);
//		
//		Parent savedParent = parentService.save(parent);
//	}
//	
//	@Test
//	@Transactional
//	public void test2B_Find_Parent_Child() throws Exception {
//		Parent parent = Parent.builder().id(1L).build();
//		Optional<Parent> findedParent1 = parentService.find(parent);
//		
//		assertThat(findedParent1.get().getChildren().get(0).getId(), is(2L));
//		assertThat(findedParent1.get().getChildren().get(1).getId(), is(3L));
//	}
	
	// 3. 영속성 전이:삭제
	// @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
	@Test
	public void test3A_SAVE_Parent_Child() throws Exception {
		Parent parent = Parent.builder().build();
		Parent savedParent = parentService.save(parent);
		
		Child child1 = Child.builder().parent(savedParent).build();
		Child savedChild1 = childService.save(child1);
		Child child2 = Child.builder().parent(savedParent).build();
		Child savedChild2 = childService.save(child2);
		
	}
	
	@Test
	public void test3B_REMOVE_Parent_Child() throws Exception {
		Parent parent = Parent.builder().id(1L).build();
		Optional<Parent> findedParent1 = parentService.find(parent);
		
		parentService.delete(findedParent1.get());
		
		List<Parent> liatParent = parentService.findAll();
		
		assertThat(liatParent.size(), is(0));
		
		List<Child> liatChild = childService.findAll();
		
		assertThat(liatChild.size(), is(0));
	}
}

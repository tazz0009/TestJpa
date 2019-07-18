package com.tazz009.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Parent {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
	private List<Child> children = new ArrayList<Child>();
	
	@Builder
	public Parent(Long id) {
		super();
		this.id = id;
	}
	
}

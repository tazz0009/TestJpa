package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Child {
	
	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;
	
	private String name;
	
	@ManyToOne(optional = false)
	@JoinTable(name = "PARENT_CHILD",
			joinColumns = @JoinColumn(name = "CHILD_ID"),
			inverseJoinColumns = @JoinColumn(name = "PARENT_ID")
		)
	private Parent parent;
	
	@Builder
	public Child(Long id, String name, Parent parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	
}

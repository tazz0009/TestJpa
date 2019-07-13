package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
	private Parent parent;
	
	
	private String name;
	
	@Builder
	public Child(String id, String name, Parent parent) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
	}
	
}

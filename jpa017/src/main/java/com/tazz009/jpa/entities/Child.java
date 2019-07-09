package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(ChildId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Child {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
	private Parent parent;
	
	@Id
	@Column(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	private String childId;
	
	private String name;
	
	@Builder
	public Child(Parent parent, String childId, String name) {
		super();
		this.parent = parent;
		this.childId = childId;
		this.name = name;
	}
	
}

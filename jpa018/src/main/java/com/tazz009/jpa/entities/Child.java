package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
	
	@EmbeddedId
	private ChildId childId;
	
	@MapsId("parentId")
	@ManyToOne
	@JoinColumn(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
	private Parent parent;
	
	
	private String name;
	
	@Builder
	public Child(Parent parent, ChildId childId, String name) {
		super();
		this.parent = parent;
		this.childId = childId;
		this.name = name;
	}
	
}

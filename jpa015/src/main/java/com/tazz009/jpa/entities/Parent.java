package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@IdClass(ParentId.class)
public class Parent {

	@Id
	@Column(name = "PARENT_ID1", columnDefinition = "VARCHAR(100)")
	private String id1;
	
	@Id
	@Column(name = "PARENT_ID2", columnDefinition = "VARCHAR(100)")
	private String id2;
	
	private String name;

	@Builder
	public Parent(String id1, String id2, String name) {
		super();
		this.id1 = id1;
		this.id2 = id2;
		this.name = name;
	}
	
}

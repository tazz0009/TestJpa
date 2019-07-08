package com.tazz009.jpa.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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

	@EmbeddedId
	private ParentId id;
	
	private String name;

	@Builder
	public Parent(ParentId id,  String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

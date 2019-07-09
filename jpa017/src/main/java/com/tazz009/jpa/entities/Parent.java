package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	@Column(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
	private String id;
	
	private String name;

	@Builder
	public Parent(String id,  String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

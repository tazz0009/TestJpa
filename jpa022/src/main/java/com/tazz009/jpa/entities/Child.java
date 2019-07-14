package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
public class Child {
	
	@Id
	@GeneratedValue
	@Column(name = "CHILD_ID")
	private Long id;
	
	private String name;
	
	@Builder
	public Child(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

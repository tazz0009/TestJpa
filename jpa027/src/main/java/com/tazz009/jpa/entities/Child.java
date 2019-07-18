package com.tazz009.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Long id;
	
	@ManyToOne
	private Parent parent;
	
	@Builder
	public Child(Long id, Parent parent) {
		super();
		this.id = id;
		this.parent = parent;
	}
	
}

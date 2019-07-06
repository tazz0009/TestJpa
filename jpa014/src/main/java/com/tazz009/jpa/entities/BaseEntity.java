package com.tazz009.jpa.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public abstract class BaseEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	public BaseEntity(String name) {
		super();
		this.name = name;
	}
	
}

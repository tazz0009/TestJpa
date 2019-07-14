package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

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
	@GeneratedValue
	@Column(name = "PARENT_ID")
	private Long id;
	
	private String name;

	@OneToOne
	@JoinTable(name = "PARENT_CHILD",
		joinColumns = @JoinColumn(name = "PARENT_ID"),
		inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
	)
	private Child child;
	
	@Builder
	public Parent(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

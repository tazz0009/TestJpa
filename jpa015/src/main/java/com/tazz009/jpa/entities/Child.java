package com.tazz009.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
	private String id;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID1", referencedColumnName = "PARENT_ID1")
		, @JoinColumn(name = "PARENT_ID2", referencedColumnName = "PARENT_ID2")
	})
	private Parent parent;

	@Builder
	public Child(String id, Parent parent) {
		super();
		this.id = id;
		this.parent = parent;
	}
	
}

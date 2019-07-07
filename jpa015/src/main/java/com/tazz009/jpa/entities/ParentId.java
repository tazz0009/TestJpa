package com.tazz009.jpa.entities;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class ParentId implements Serializable {

	private String id1;
	private String id2;
	
	public ParentId() {
	}

	public ParentId(String id1, String id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}
	
}

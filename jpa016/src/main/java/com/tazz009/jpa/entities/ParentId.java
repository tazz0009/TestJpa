package com.tazz009.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode
public class ParentId implements Serializable {

	@Column(name = "PARENT_ID1", columnDefinition = "VARCHAR(100)")
	private String id1;
	@Column(name = "PARENT_ID2", columnDefinition = "VARCHAR(100)")
	private String id2;
	
	public ParentId() {
	}

	public ParentId(String id1, String id2) {
		super();
		this.id1 = id1;
		this.id2 = id2;
	}
	
}

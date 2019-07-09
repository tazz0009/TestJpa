package com.tazz009.jpa.entities;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@EqualsAndHashCode
public class ChildId implements Serializable {

	private String parent;
	private String childId;
	
	@Builder
	public ChildId(String parent, String childId) {
		super();
		this.parent = parent;
		this.childId = childId;
	}
	
}

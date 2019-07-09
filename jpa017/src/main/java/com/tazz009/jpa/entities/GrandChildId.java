package com.tazz009.jpa.entities;

import java.io.Serializable;

import javax.persistence.JoinColumn;

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
public class GrandChildId implements Serializable {
	
	private ChildId child;
	private String id;
	
	@Builder
	public GrandChildId(ChildId child, String id) {
		super();
		this.child = child;
		this.id = id;
	}
	
}

package com.tazz009.jpa.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@EqualsAndHashCode
public class GrandChildId implements Serializable {
	
	@Column(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	private ChildId childId;
	
	@Column(name = "GRANDCHILD_ID", columnDefinition = "VARCHAR(50)")
	private String id;
	
	@Builder
	public GrandChildId(ChildId childId, String id) {
		super();
		this.childId = childId;
		this.id = id;
	}
	
}

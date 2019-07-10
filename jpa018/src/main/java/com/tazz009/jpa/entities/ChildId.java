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
public class ChildId implements Serializable {

	@Column(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
	private String parentId;
	
	@Column(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	private String childId;
	
	@Builder
	public ChildId(String parentId, String childId) {
		super();
		this.parentId = parentId;
		this.childId = childId;
	}
	
}

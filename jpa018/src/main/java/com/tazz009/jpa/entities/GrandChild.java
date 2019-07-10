package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class GrandChild {

	@EmbeddedId
	private GrandChildId id;
	
	@MapsId("childId")
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
		,@JoinColumn(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	})
	private Child child;
	
	private String name;
	
	@Builder
	public GrandChild(GrandChildId id, Child child, String name) {
		super();
		this.id = id;
		this.child = child;
		this.name = name;
	}
	
}

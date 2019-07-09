package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(GrandChildId.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class GrandChild {
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID", columnDefinition = "VARCHAR(50)")
		,@JoinColumn(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	})
	private Child child;
	
	@Id
	@Column(name = "GRANDCHILD_ID", columnDefinition = "VARCHAR(50)")
	private String id;
	
	private String name;
	
	@Builder
	public GrandChild(Child child, String id, String name) {
		super();
		this.child = child;
		this.id = id;
		this.name = name;
	}
	
}

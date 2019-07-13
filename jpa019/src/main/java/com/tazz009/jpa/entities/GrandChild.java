package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class GrandChild {

	@Id
	@Column(name = "GRANDCHILD_ID", columnDefinition = "VARCHAR(50)")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "CHILD_ID", columnDefinition = "VARCHAR(50)")
	private Child child;
	
	private String name;
	
	@Builder
	public GrandChild(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

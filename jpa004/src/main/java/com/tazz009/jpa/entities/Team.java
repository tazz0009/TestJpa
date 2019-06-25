package com.tazz009.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TEAM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Team {

	@Id
	@Column(name = "TEAM_ID")
	private String id;
	
	private String name;

	@OneToMany(mappedBy = "team"
			, fetch = FetchType.EAGER
			)
	private List<Member> members = new ArrayList<Member>();
	
	@Builder
	public Team(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

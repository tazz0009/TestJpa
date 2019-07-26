package com.tazz009.jpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	private String username;
	private Integer age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Team team;
	
//	@OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//	private List<Order> orders;
	
	@Builder
	public Member(Long id, String username, Team team, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.team = team;
		this.age = age;
	}
	
}

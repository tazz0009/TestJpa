package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME")
	private String username;
	
	private Integer age;
	
	@Builder
	public Member(String id, String username, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}
	
}

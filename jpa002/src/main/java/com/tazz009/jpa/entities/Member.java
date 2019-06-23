package com.tazz009.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MEMBER", uniqueConstraints = {@UniqueConstraint(
		name = "NAME_AGE_UNIQUE",
		columnNames = {"NAME", "AGE"}
		)})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Member {

	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String username;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate;
	
	@Lob
	private String description;

	@Builder
	public Member(String id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate,
			String description) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.roleType = roleType;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.description = description;
	}
	
}

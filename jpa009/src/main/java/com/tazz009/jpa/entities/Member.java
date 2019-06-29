package com.tazz009.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString
public class Member {

	@Id
	@Column(name = "MEMBER_ID", columnDefinition = "VARCHAR(100)")
	private String id;
	
	private String username;
	
	@OneToMany(mappedBy = "member")
	private List<MemberProduct> memberProducts = new ArrayList<MemberProduct>();

	@Builder
	public Member(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

}

package com.tazz009.jpa.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private Long id;
	private String name;

	@Embedded
	private Address homeAddress;

	@Builder
	public Member(Long id, 
			String name, Address homeAddress) {
		super();
		this.id = id;
		this.name = name;
		this.homeAddress = homeAddress;
	}

}

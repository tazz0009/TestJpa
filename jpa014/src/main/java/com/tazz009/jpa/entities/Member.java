package com.tazz009.jpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AttributeOverride(name = "id", column = @Column(name = "MEMBER_ID"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Member extends BaseEntity {

	private String email;

	@Builder
	public Member(String name, String email) {
		super(name);
		this.email = email;
	}
	
}

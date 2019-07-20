package com.tazz009.jpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
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

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY"))
		,@AttributeOverride(name = "street", column = @Column(name = "COMPANY_STREET"))
		,@AttributeOverride(name = "zipcode", column = @Column(name = "COMPANY_ZIPCODE"))
	})
	private Address companyAddress;
	
	@Builder
	public Member(Long id, 
			String name, Address homeAddress, Address companyAddress) {
		super();
		this.id = id;
		this.name = name;
		this.homeAddress = homeAddress;
		this.companyAddress = companyAddress;
	}

}

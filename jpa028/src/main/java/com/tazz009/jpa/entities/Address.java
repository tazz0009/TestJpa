package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Embeddable
public class Address {
	
//	@Column(name = "city")
	private String city;
	private String street;
	private String zipcode;
	
	@Builder
	public Address(String city, String street, String zipcode) {
		super();
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}
	
}

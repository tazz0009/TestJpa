package com.tazz009.jpa.entities;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Setter//불변객체로 만들어준다.
@Getter
@Embeddable
public class Address {
	
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

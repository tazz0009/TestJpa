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

	// step 2 -->
	// 근무 기간
	@Embedded
	private Period workPeriod;
	// 집주소 표현
	@Embedded
	private Address homeAddress;
	
	@Builder
	public Member(Long id, 
			String name, Period workPeriod, Address homeAddress) {
		super();
		this.id = id;
		this.name = name;
		this.workPeriod = workPeriod;
		this.homeAddress = homeAddress;
	}
	// step 2 <--
	
	// step 1 -->
	// 근무 기간
//	@Temporal(TemporalType.DATE)
//	private Date startDate;
//	@Temporal(TemporalType.DATE)
//	private Date endtDate;

	// 집주소 표현
//	private String city;
//	private String street;
//	private String zipcode;
	
//	@Builder
//	public Member(Long id, 
//			String name, Date startDate, Date endtDate, 
//			String city, String street, String zipcode) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.startDate = startDate;
//		this.endtDate = endtDate;
//		this.city = city;
//		this.street = street;
//		this.zipcode = zipcode;
//	}
	// step 1 <--

}

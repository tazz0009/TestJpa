package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LOCKER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Locker {

	@Id
	@GeneratedValue
	@Column(name = "LOCKER_ID")
	private Long id;
	
	private String name;
	
	@OneToOne(mappedBy = "locker")
	private Member member;
	
	@Builder
	public Locker(String name) {
		super();
		this.name = name;
	}
	
}

package com.tazz009.jpa.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("A")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString
public class Album extends Item {

	private String artist;

	@Builder
	public Album(String name, int price, String artist) {
		super(name, price);
		this.artist = artist;
	}
	
}

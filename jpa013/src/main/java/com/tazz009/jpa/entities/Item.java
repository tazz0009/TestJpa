package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString
public abstract class Item {

	@Id 
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;
	
	private String name;
	private int price;
	
	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
}

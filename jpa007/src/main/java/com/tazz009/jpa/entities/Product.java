package com.tazz009.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	private String id;
	
	private String name;

	@Builder
	public Product(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}

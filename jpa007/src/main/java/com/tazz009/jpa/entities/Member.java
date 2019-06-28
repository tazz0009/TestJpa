package com.tazz009.jpa.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@ToString
public class Member {

	@Id
	@Column(name = "MEMBER_ID")
	private String id;
	
	private String username;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "MEMBER_PRODUCT"
			, joinColumns = @JoinColumn(name = "MEMBER_ID")
			, inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
	private List<Product> products = new ArrayList<Product>();

	@Builder
	public Member(String id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public void addProduct(Optional<Product> product) {
		if (!product.isEmpty()) {
			this.products.add(product.get());
		}
	}
}

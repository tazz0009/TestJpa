package com.tazz009.jpa.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "SELER_ID"))
	,@AttributeOverride(name = "name", column = @Column(name = "SELLER_NAME"))
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public class Seller extends BaseEntity {

	private String shopName;

	@Builder
	public Seller(String name, String shopName) {
		super(name);
		this.shopName = shopName;
	}
	
}

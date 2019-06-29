package com.tazz009.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MemberProduct")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Setter
@Getter
//@ToString
@IdClass(MemberProductId.class)
public class MemberProduct {

	@Id
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID"
			, columnDefinition = "VARCHAR(100)"
			, insertable = false
			, updatable = false)
	private Member member;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID"
			, columnDefinition = "VARCHAR(100)")
	private Product product;
	
	private int orderAmount;
}

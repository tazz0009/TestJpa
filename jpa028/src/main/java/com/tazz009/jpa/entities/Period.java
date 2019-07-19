package com.tazz009.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
@Embeddable
public class Period {

	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endtDate;
	
	@Builder
	public Period(Date startDate, Date endtDate) {
		super();
		this.startDate = startDate;
		this.endtDate = endtDate;
	}
	
}

package com.stackoverflow.entity;

import java.util.Date;

public class Bounty {
	 private int reputation;
	 private Date expirationdate;
	public Bounty(int reputation, Date expirationdate) {
		super();
		this.reputation = reputation;
		this.expirationdate = expirationdate;
	}
	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}
	public Date getExpirationdate() {
		return expirationdate;
	}
	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}
}

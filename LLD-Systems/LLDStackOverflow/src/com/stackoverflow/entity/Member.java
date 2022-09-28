package com.stackoverflow.entity;

import java.util.List;

public class Member {
	public enum AccountStatus {
		ACTIVE,  BLOCKED
	}

	private List<Question> questions;
	private Integer id;
	private AccountStatus accountStatus;
	private String name;
	private String email;
	private int reputation;
	private boolean isModerator;
	private boolean isAdmin;
	private static int counter = 0;

	public Member( String name, String email, boolean isModerator, boolean isAdmin) {
		super();
		id = ++counter;
		this.accountStatus = AccountStatus.ACTIVE;
		this.name = name;
		this.email = email;
		this.reputation = 0;
		this.isModerator = isModerator;
		this.isAdmin = isAdmin;
	}

	public Integer getId() {
		return id;
	}


	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public boolean isModerator() {
		return isModerator;
	}

	public void setModerator(boolean isModerator) {
		this.isModerator = isModerator;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Question> getQuestions() {
		return questions;
	}
}

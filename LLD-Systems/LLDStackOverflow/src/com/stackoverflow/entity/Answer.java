package com.stackoverflow.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class Answer {
	private boolean solvedProblem; // is this answer a proper solution to the question ?
	private List<Comment> comments;
	protected long id; // there is no need to expose id hence private.
	private int upvote;
	private int downvote;
	

	protected String text;
	protected LocalDateTime creationDateTime;
	protected LocalDateTime lastUpdated;
	protected Member creator;
	protected List<Photo> photos;
	protected Set<Integer> membersWhoDownvotedThisAnswer;
	protected Set<Integer> membersWhoUpvotedThisAnswer;
	protected int numberOfUsersReportedThisEntity; // members reported as spam or abuse
	private static int ctr = 0;

	public Answer(boolean solvedProblem, String text, Member creator) {
		super();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		this.solvedProblem = solvedProblem;
		this.id = ++ctr;
		this.text = text;
		this.creationDateTime = now;
		this.lastUpdated = now;
		this.creator = creator;
		this.upvote=0;
	}
	
	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public boolean isSolvedProblem() {
		return solvedProblem;
	}

	public void setSolvedProblem(boolean solvedProblem) {
		this.solvedProblem = solvedProblem;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Member getCreator() {
		return creator;
	}

	public void setCreator(Member creator) {
		this.creator = creator;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public Set<Integer> getMembersWhoDownvotedThisAnswer() {
		return membersWhoDownvotedThisAnswer;
	}


	public Set<Integer> getMembersWhoUpvotedThisAnswer() {
		return membersWhoUpvotedThisAnswer;
	}

	

	public int getNumberOfUsersReportedThisEntity() {
		return numberOfUsersReportedThisEntity;
	}

	public void setNumberOfUsersReportedThisEntity(int numberOfUsersReportedThisEntity) {
		this.numberOfUsersReportedThisEntity = numberOfUsersReportedThisEntity;
	}

}

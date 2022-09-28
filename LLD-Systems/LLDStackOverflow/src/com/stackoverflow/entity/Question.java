package com.stackoverflow.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {
	private Integer id;
	private String title;
	private String description;
	private Status status;
	private Bounty bounty;
	private Member member;
	private LocalDateTime created;
	private LocalDateTime updated;
	private Set<Integer>whoUpVotedThisQuestion;
	private Set<Integer>whoDownVotedThisQuestion;
	private List<Tag> tags;
	private List<Comment> comments;
	private List<Answer> answers;
	private Integer upvote;
	private Integer downvote;
	

	private static int counter = 0;

	public Question(String title, String description, Status status, Bounty bounty, List<Tag> tags, Member member) {
		super();
		this.id = ++counter;
		this.title = title;
		this.status = status;
		this.description = description;
		this.bounty = bounty;
		this.tags = tags;
		this.member = member;
		this.upvote = 0;
		created = LocalDateTime.now();
		updated = LocalDateTime.now();
		whoUpVotedThisQuestion=new HashSet<>();
		whoDownVotedThisQuestion=new HashSet<>();
	}
	
	
	public Integer getDownvote() {
		return downvote;
	}

	public void setDownvote(Integer downvote) {
		this.downvote = downvote;
	}
	public Set<Integer> getWhoUpVotedThisQuestion() {
		return whoUpVotedThisQuestion;
	}


	public Set<Integer> getWhoDownVotedThisQuestion() {
		return whoDownVotedThisQuestion;
	}

	
	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Integer getUpvote() {
		return upvote;
	}

	public void setUpvote(Integer upvote) {
		this.upvote = upvote;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Bounty getBounty() {
		return bounty;
	}

	public void setBounty(Bounty bounty) {
		this.bounty = bounty;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}

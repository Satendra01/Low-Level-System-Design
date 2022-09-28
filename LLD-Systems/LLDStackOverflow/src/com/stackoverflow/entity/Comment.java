package com.stackoverflow.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Comment {
	Member commenter;
	String text;
	LocalDateTime created;
	LocalDateTime updated;

	List<Photo> photos;

	public Comment(Member commenter, String text, List<Photo> photos) {
		super();
		this.commenter = commenter;
		this.text = text;
		this.photos = photos;
		created = LocalDateTime.now();
		updated = LocalDateTime.now();
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Member getCommenter() {
		return commenter;
	}

	public void setCommenter(Member commenter) {
		this.commenter = commenter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
}

package com.stackoverflow.entity;

public class Photo {
	 private long id;
	    private String photoPath;
	    private long creationDate;
	    private Member creatingMember;
		public Photo(long id, String photoPath, long creationDate, Member creatingMember) {
			super();
			this.id = id;
			this.photoPath = photoPath;
			this.creationDate = creationDate;
			this.creatingMember = creatingMember;
		}
}

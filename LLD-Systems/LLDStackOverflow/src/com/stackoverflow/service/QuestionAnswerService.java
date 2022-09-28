package com.stackoverflow.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.entity.Bounty;
import com.stackoverflow.entity.Comment;
import com.stackoverflow.entity.Member;
import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.Status;
import com.stackoverflow.entity.Tag;

public class QuestionAnswerService {
	Map<Integer,Question>questions=new HashMap<>();
	Map<Long,Answer>answers=new HashMap<>();
	
	public void addQuestion(String title,String description, Bounty bounty, Member member,List<Tag>tags)
	{
		if(checkIfQuestionExists(description))
			throw new Exception("Question Already Exists");
		Status status=Status.OPEN;
			
		Question question=new Question(title,description, status,bounty,tags,member);
		member.getQuestions().add(question);
		questions.put(question.getId(),question);
			
	}
	public void addAnswerToQuestion(String answer,Question question,boolean isProblemSolved,Member member)
	{
		
		Answer ans=new Answer(isProblemSolved,answer,member);
		question.getAnswers().add(ans);
		answers.put(ans.getId(),ans);
	}
	
	public void addCommentToQuestion(Question question, String comment,Member member)
	{
		
		Comment com=new Comment(member,comment,null);
		question.getComments().add(com);
	}
	public void addCommentToAnswer(Answer answer, String comment,Member member)
	{
		Comment com=new Comment(member,comment,null);
		answer.getComments().add(com);
	}
	public void editBounty(Question question, Bounty bounty)
	{
		question.setBounty(bounty);
	}
	public void addUpVoteToQuestion(Question question,Member member)
	{
		if(!question.getWhoUpVotedThisQuestion().contains(member.getId()))
		{
			question.setUpvote(question.getUpvote()+1);
			question.getWhoUpVotedThisQuestion().add(member.getId());
		}
	}
	public void addUpVoteToAnswer(Answer answer,Member member)
	{
		if(!answer.getMembersWhoUpvotedThisAnswer().contains(member.getId()))
			{
				answer.setUpvote(answer.getUpvote()+1);
				answer.getMembersWhoUpvotedThisAnswer().add(member.getId());
			}
	}
	public void addDownVoteToQuestion(Question question,Member member)
	{
		if(!question.getWhoDownVotedThisQuestion().contains(member.getId()))
		{
			question.setDownvote(question.getUpvote()+1);
			question.getWhoDownVotedThisQuestion().add(member.getId());
		}
	}
	public void addDownVoteToAnswer(Answer answer,Member member)
	{
		if(!answer.getMembersWhoDownvotedThisAnswer().contains(member.getId()))
		{
			answer.setDownvote(answer.getUpvote()+1);
			answer.getMembersWhoDownvotedThisAnswer().add(member.getId());
		}
			
	}
	public void editQuestion(Question question, String title, String desc)
	{
		question.setTitle(title);
		question.setDescription(desc);
		question.setUpdated(LocalDateTime.now());
	}
	public void editAnswer(Answer answer, String desc)
	{
		answer.setText(desc);
		answer.setLastUpdated(LocalDateTime.now());
	}
	public void closeQuestion(int questionId, int memberId)
	{
		Question question=questions.get(questionId);
		Member member=MemberService.getMembers().get(memberId);
		if(member.isAdmin() || member.isModerator())
			question.setStatus(Status.CLOSED);
	}
	public void reOpenQuestion(int questionId,int memberId)
	{
		Question question=questions.get(questionId);
		Member member=MemberService.getMembers().get(memberId);
		if(member.isAdmin() || member.isModerator())
			question.setStatus(Status.OPEN);
	}
	public void updateCommentToQuestion(String desc,int questionId, int memberId,int commentId)
	{
		Question question=questions.get(questionId);
		Comment c=question.getComments().get(commentId);
		if(c.getCommenter().getId()==memberId)
			c.setText(desc);
			
	}
}

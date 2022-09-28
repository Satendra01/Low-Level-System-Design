package com.stackoverflow.controller;

import java.time.LocalDateTime;
import java.util.List;

import com.stackoverflow.entity.Answer;
import com.stackoverflow.entity.Bounty;
import com.stackoverflow.entity.Comment;
import com.stackoverflow.entity.Member;
import com.stackoverflow.entity.Question;
import com.stackoverflow.entity.Status;
import com.stackoverflow.entity.Tag;
import com.stackoverflow.service.MemberService;
import com.stackoverflow.service.QuestionAnswerService;

public class QuestionAnswerController {
	private QuestionAnswerService questionAnswerService;
	private MemberService memberService;
	public QuestionAnswerController(QuestionAnswerService questionAnswerService, MemberService memberService) {
		super();
		this.questionAnswerService = questionAnswerService;
		this.memberService = memberService;
	}
	public void addQuestion(String title,String description, Bounty bounty, Member member,List<Tag>tags)
	{
		questionAnswerService.addQuestion(title, description, bounty, member, tags);
			
	}
	public void addAnswerToQuestion(String answer,Question question,boolean isProblemSolved,Member member)
	{
		questionAnswerService.addAnswerToQuestion(answer, question, isProblemSolved, member);
		
	}
	
	public void addCommentToQuestion(Question question, String comment,Member member)
	{
		questionAnswerService.addCommentToQuestion(question, comment, member);
	}
	public void addCommentToAnswer(Answer answer, String comment,Member member)
	{
		questionAnswerService.addCommentToAnswer(answer, comment, member);
	}
	public void editBounty(Question question, Bounty bounty)
	{
		questionAnswerService.editBounty(question, bounty);
	}
	public void addUpVoteToQuestion(Question question,Member member)
	{
		questionAnswerService.addUpVoteToQuestion(question, member);
	}
	public void addUpVoteToAnswer(Answer answer,Member member)
	{
		questionAnswerService.addUpVoteToAnswer(answer, member);
	}
	public void addDownVoteToQuestion(Question question,Member member)
	{
		questionAnswerService.addDownVoteToQuestion(question, member);
	}
	public void addDownVoteToAnswer(Answer answer,Member member)
	{
			questionAnswerService.addDownVoteToAnswer(answer, member);
	}
	public void editQuestion(Question question, String title, String desc)
	{
		questionAnswerService.editQuestion(question, title, desc);
	}
	public void editAnswer(Answer answer, String desc)
	{
		questionAnswerService.editAnswer(answer, desc);
	}
	public void closeQuestion(int questionId, int memberId)
	{
		questionAnswerService.closeQuestion(questionId, memberId);
	}
	public void reOpenQuestion(int questionId,int memberId)
	{
		questionAnswerService.reOpenQuestion(questionId, memberId);
	}
	public void updateCommentToQuestion(String desc,int questionId, int memberId,int commentId)
	{
			questionAnswerService.updateCommentToQuestion(desc, questionId, memberId, commentId);
	}
}

package com.stackoverflow.basetest;

import com.stackoverflow.controller.MemberController;
import com.stackoverflow.controller.QuestionAnswerController;

public class BaseTest {
	
	private MemberController memberController;
	private QuestionAnswerController questionAnswerController;
	@Mock
	private MemberService memberService;
	@Mock
	private QuestionAnswerService questionAnswerService;
	@Before
	public void setup()
	{
		memberController=new MemberController(memberService);
		questionAnswerController=new QuestionAnswerController(questionAnswerService,memberService);
	}
	
	
}

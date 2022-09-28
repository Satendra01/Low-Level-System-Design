package com.stackoverflow.controller;

import com.stackoverflow.entity.Member;
import com.stackoverflow.service.MemberService;

public class MemberController {
	private MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	public void addMember(String name, String email,boolean moderator,boolean admin)
	{
		memberService.addMember(name, email, moderator, admin);
	}
	
	public void blockMember(Member memberToBeBlocked, Member moderator) throws Exception
	{
		memberService.blockMember(memberToBeBlocked, moderator);
	}
	
	public void UnblockMember(Member memberToBeUnBlocked, Member moderator) throws Exception
	{
		memberService.UnblockMember(memberToBeUnBlocked, moderator);
	}
	
}

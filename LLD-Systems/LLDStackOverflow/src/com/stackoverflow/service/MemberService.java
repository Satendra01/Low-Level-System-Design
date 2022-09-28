package com.stackoverflow.service;

import java.util.HashMap;
import java.util.Map;

import com.stackoverflow.entity.Member;
import com.stackoverflow.entity.Member.AccountStatus;

public class MemberService {
	private static Map<Integer,Member>members=new HashMap<>();
	

	private static int ctr=0;
	public static Map<Integer, Member> getMembers() {
		return members;
	}
	public void addMember(String name, String email,boolean moderator,boolean admin)
	{
		if(checkIfAlreadyPresent(name,email))
			throw new Exception("User Already Registered");
		Member member=new Member(name,email,moderator,admin);
		members.put(++ctr, member);
			
	}
	
	public void blockMember(Member memberToBeBlocked, Member moderator) throws Exception
	{
		if(moderator.isModerator() || moderator.isAdmin())
		memberToBeBlocked.setAccountStatus(AccountStatus.BLOCKED);
		else
			throw new Exception("Not previlige user");
	}
	
	public void UnblockMember(Member memberToBeUnBlocked, Member moderator) throws Exception
	{
		if(moderator.isModerator() || moderator.isAdmin())
		memberToBeUnBlocked.setAccountStatus(AccountStatus.ACTIVE);
		else
			throw new Exception("Not previlige user");
	}
	
	
}

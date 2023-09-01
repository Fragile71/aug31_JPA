package com.poseidon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.poseidon.entity.Member;
import com.poseidon.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		//Member(mno=0, mname=null, mid=poseidon, mpw=01234, mjoindate=null)
		System.out.println(member);
		
		int count = memberService.count(member);
		System.out.println("카운트 : " + count);
		if(count == 1) {
			Member result = memberService.findByMidAndMpw(member);
			System.out.println("name : " + result);
			session.setAttribute("id", result.getMid());
			session.setAttribute("name", result.getMname());
			
			//name : Member(mno=1, mname=pororo, mid=pororo, mpw=1, mjoindate=2023-08-31T22:08:43)
			return "redirect:/index"; 
		}else {
			return "login";			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

package com.poseidon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.entity.Member;
import com.poseidon.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	/* 	findAll()	전체 가져오기
	* 	findOne()	하나 가져오기
	 * 	save()		저장하기 / 수정하기
	 * 	count()		
	 * 	delete()	
	 * 
	 */

	public Member findByMid(String mid) {
		return memberRepository.findByMid(mid);
	}

	public List<Member> findTop5ByOrderByMnoDesc() {
		return memberRepository.findTop5ByOrderByMnoDesc();
	}

	public Member findByMidAndMpw(Member member) {
		return memberRepository.findByMidAndMpw(member.getMid(), member.getMpw());
	}

	public int count(Member member) {
		return memberRepository.count(member.getMid(), member.getMpw());
	}


	//여긴 삭제
	//public String findByMname(Member member) {
		//return memberRepository.findByMname(member);
//	}

}

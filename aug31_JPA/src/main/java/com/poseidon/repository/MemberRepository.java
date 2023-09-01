package com.poseidon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.poseidon.entity.Member;

public interface MemberRepository extends Repository<Member, Long> {

	List<Member> findAll();

	void save(Member member);

	Member findByMid(String string);//문자열(id)이 들어오면 해당 사용자의 정보 찾아오기

	List<Member> findTop5ByOrderByMnoDesc();

	@Query(value = "SELECT count(*) FROM jmember j WHERE j.mid=?1 AND j.mpw=?2", nativeQuery = true)
	int count(String mid, String mpw);

	Member findByMidAndMpw(String mid, String mpw);

	//삭제
	//String findByMid(String string);
}

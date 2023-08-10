package com.mycom.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.member.repository.MemberRepositoryImpl;

//InterfaceMemberRepository의 구현클래스가 될 얘정
//public class MemberRepositoryImpl implements MemberRepository
//Controller->Service->DAO(repository)->myBatis->DB
@Service
public class MemberServiceImpl {
	//필드
	@Autowired
	private MemberRepositoryImpl memberRepositoryImpl; 
	
	//생성자
	//메서드
	//회원수 조회
	public int getTotalMemberCNT() {
		int totalMemberCNT = memberRepositoryImpl.selectTotalMemberCNT();//dao의 메소드호출
		return totalMemberCNT;
	}
	//id로 회원정보조회
	//목록조회 
	
	
}

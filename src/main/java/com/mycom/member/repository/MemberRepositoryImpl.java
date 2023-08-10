package com.mycom.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//InterfaceMemberRepository의 구현클래스가 될 얘정
//public class MemberRepositoryImpl implements MemberRepository
//DAO역할을 하는 클래스. DB작업
//Controller->Service->DAO->myBatis->DB
@Repository
public class MemberRepositoryImpl{
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	//메서드
	//회원수 조회
	public int selectTotalMemberCNT() {
		int totalMemberCNT = (Integer)sqlSession.selectOne("member.totalMemberCNT");
		return totalMemberCNT;
	}
	//id로 회원정보조회
	//목록조회 
	
}

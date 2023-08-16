package com.mycom.member.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycom.member.domain.MemberDTO;

public interface MemberRepository {
	
	//회원수조회
	public int selectTotalMemberCNT() throws DataAccessException;

	//id로 회원정보조회
	public MemberDTO selectMemberById(String memberid) throws DataAccessException;
	
	//목록조회
	public  List<HashMap<String,Object>> selectMemberList(HashMap<String,Object> map) throws DataAccessException;
	
	//(update용)회원삭제
	public int updateIsShow(String memberid) throws DataAccessException;
	
	//회원가입
	public int insertMember(MemberDTO memberDTO) throws DataAccessException;
	
	//수정처리
	public int updateMember(Map<String, Object> map) throws DataAccessException;
	
}

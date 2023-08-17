package com.mycom.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycom.member.domain.MemberDTO;

public interface MemberService {

	//회원수 조회
	public int getTotalMemberCNT() throws Exception;
	
	//id로 회원정보조회
	public MemberDTO getMemberById(String memberid)throws Exception;
	
	//목록조회
	public  List<HashMap<String,Object>> getMemberList(HashMap<String,Object> map) throws Exception;
	//public  List<HashMap<String,Object>> getMemberList(HashMap<String,Object> map) throws Exception;
	
	//회원삭제
	public int deleteMember(String memberid) throws Exception;
	
	//회원가입
	public int insertMember(MemberDTO memberDTO) throws Exception;
	
	//수정처리
	public int modifyMember(Map<String, Object> map)  throws Exception;
}

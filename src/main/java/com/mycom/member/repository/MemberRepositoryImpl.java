package com.mycom.member.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycom.member.domain.MemberDTO;

//InterfaceMemberRepository의 구현클래스가 될 얘정
//public class MemberRepositoryImpl implements MemberRepository
//DAO역할을 하는 클래스. DB작업
//Controller->Service->DAO->myBatis->DB
@Repository
public class MemberRepositoryImpl implements MemberRepository {
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	//메서드
	//회원수 조회
	@Override
	public int selectTotalMemberCNT()  throws DataAccessException{
		int totalMemberCNT = (Integer)sqlSession.selectOne("member.totalMemberCNT");
		return totalMemberCNT;
	}
	
	//id로 회원정보조회
	//파라미터 String memberid - 조회하고 싶은 회원의 id
	//리턴 MemberDTO- no,memberid,password,name,regdate,isshow
	@Override
	public MemberDTO selectMemberById(String memberid)  throws DataAccessException{
		MemberDTO memberDTO=(MemberDTO)sqlSession.selectOne("member.selectById",memberid);
		return memberDTO;
	}
	
	//목록조회
	/*리턴 List<HashMap<String,Object>>
	HashMap은 Key, Value를 필요로 한다.
	이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
	예) 컬럼명 no,memberid,password,name,regdate,isshow
	예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
	Key no에는 숫자타입2가 저장
	Key memberid에는 문자타입 hongid가 저장
	한명의 회원 정보는 HashMap저장.
	다수의 회원정보들이므로 List에 넣어줬다.*/
	/*	<select id="selectMemberList" resultType="hashmap">
		select no,memberid,password,name,regdate,isshow*/
	@Override
	public  List<HashMap<String,Object>> selectMemberList()  throws DataAccessException{
		//sqlSession참조변수.메서드명("네임스페이스명.실행하려는id")
		 List<HashMap<String,Object>> memberList = sqlSession.selectList("member.selectMemberList");
		 return memberList;
	}
	
	//(update용)회원삭제
	//파라미터  String memberid-삭제하고 싶은 회원id
	//리턴 int - (update용)회원삭제 성공하면 1을 반환
	@Override
	public int updateIsShow(String memberid)  throws DataAccessException{
		int rowCnt = sqlSession.update("member.updateIsShow",memberid);
		//update가 적용된 row수를 반환
		//여기에서는 pk인 회원id로 업데이트되므로 성공하면 1을 반환
		return rowCnt;
	}
	
	//회원가입
	//<insert id="insertMember" parameterType="com.mycom.member.domain.memberDTO">
	//파라미터 MemberDTO memberDTO-회원가입에 필요한 data
	//리턴 int - 입력성공시 1을 반환
	@Override
	public int insertMember(MemberDTO memberDTO)  throws DataAccessException{
		return sqlSession.insert("member.insertMember",memberDTO);
		//입력성공시 1을 반환
	}
	
	//수정처리
	/*파라미터:form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		회원번호의  key는 "no			회원id의  key는 "memberid"
		회원명의 key는 "name"		회원명의  key는 "password"*/
	//리턴 int - 수정성공시 1을 반환
	@Override
	public int updateMember(Map<String, Object> map)  throws DataAccessException{
		return sqlSession.update("member.updateMember", map);
		//수정성공시 1을 반환
	}
	
}

package com.mycom.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycom.member.domain.MemberDTO;
import com.mycom.member.service.MemberServiceImpl;

//Controller->Service->DAO(repository)->myBatis->DB
@Controller
@RequestMapping("/member")
public class MemberController {
	//필드
	@Autowired
	private MemberServiceImpl memberServiceImpl;
	
	//생성자
	//메서드
	//전체회원수 조회
	//요청주소 http://localhost:8081/app/totalMember
	//get방식
	@RequestMapping("/totalMember")
	public void  getTotalMemberCNT(Model model) {
		//1.파라미터받기
		//2.비지니스로직<->Service<->DAO(repository)<->myBatis<->DB
		int totalMemberCNT = memberServiceImpl.getTotalMemberCNT();
		
		//3.Model
		model.addAttribute("totalMemberCNT",totalMemberCNT);
		System.out.println("전체회원수 totalMemberCNT:"+totalMemberCNT);
		//4.View->여기에서는 WEB-INF/views/member/totalMember.jsp 존재하지 않으므로 404에러발생
		//return "member/totalMember";
	}
	
	//id로 회원정보조회
	@RequestMapping("/getMember")
	//리턴 MemberDTO- no,memberid,password,name,regdate,isshow
	public String getMemberById(Model model) {
		MemberDTO memberDTO = memberServiceImpl.getMemberById();
		System.out.println(memberDTO);
		model.addAttribute("memberDTO",memberDTO);
		return "/member/memberInfo";
	}
	
	//목록조회 
	//@RequestMapping("/getMemberList")
}

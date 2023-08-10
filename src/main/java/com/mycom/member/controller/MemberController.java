package com.mycom.member.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	//요청주소 http://localhost:8081/app/member/getMember?mid=회원id
	@RequestMapping("/getMember")
	//리턴 MemberDTO- no,memberid,password,name,regdate,isshow
	public String getMemberById(Model model,
																		@RequestParam("mid") String memberid) {
		//파라미터받기 - 회원id
		//String memberid=request.getParameter("mid");
		
		//2.비지니스로직<->Service<->DAO(Repository)<->myBatis<->DB
		MemberDTO memberDTO = memberServiceImpl.getMemberById(memberid);
		System.out.println(memberDTO);
		
		//3.Model
		model.addAttribute("memberDTO",memberDTO);
		//4.View
		return "/member/memberInfo";
	}
	
	//목록조회
	//요청주소 http://localhost:8081/app/member/list
	//요청방식 get
	//view	 /WEB-INF/views/member/list.jsp
	@RequestMapping("/list")
	public void getMemberList(Model model) {
		/*리턴 List<HashMap<String,Object>>
		HashMap은 Key, Value를 필요로 한다.
		이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
		예) 컬럼명 no,memberid,password,name,regdate,isshow
		예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
		Key no에는 숫자타입2가 저장
		Key memberid에는 문자타입 hongid가 저장
		한명의 회원 정보는 HashMap저장.
		다수의 회원정보들이므로 List에 넣어줬다.*/
		List<HashMap<String, Object>> memberlist = memberServiceImpl.getMemberList();
		model.addAttribute("memberlist", memberlist);
		
		//return "/member/list";
	}
	
	//수정-수정폼보여주기요청=>get방식
	//@RequestMapping("member/modify")
	//1.파라미터받기 no=회원번호

	//수정처리=>post방식
	//@RequestMapping("member/modify")
	//1.파라미터받기 mid=회원id
	
	//삭제
	//요청주소 http://localhost:8081/app/member/delete?mid=회원id
	@RequestMapping("/delete")
	public ModelAndView deleteMember(ModelAndView mv,
									@RequestParam("mid") String mid)  {
		//1.파라미터받기 mid=회원id
		//2.비지니스로직
		//파라미터  String mid-삭제하고 싶은 회원id
		//리턴 int - (update용)회원삭제 성공하면 1을 반환
		int rowCnt = memberServiceImpl.deleteMember(mid);
		
		//3.Model
		//4.View
		if(rowCnt!=1) {//삭제실패시 상세페이지로 이동
			mv.setViewName("redirect:/member/getMember?mid"+mid);
		}else{//삭제성공시 목록페이지로 이동
			mv.setViewName("redirect:/member/list");
		}
		return mv;
	}
	
	//가입-회원등록을 위한 폼보여줘 요청
	//요청주소 http://localhost:8081/app/member/join
	//요청방식 get
	//view	/WEB-INF/views/member/join.jsp
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public void joinForm(){
		//1.파라미터받기
		//2.비지니스로직
		//3.Model
		//4.View
	}

	//가입처리-회원등록 처리
	//요청주소 http://localhost:8081/app/member/join
	//요청방식 post
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public ModelAndView join(ModelAndView mv,MemberDTO memberDTO){
		//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,id,이름,비번 등
		System.out.println(memberDTO);
		
		//2.비지니스로직
		//파라미터 MemberDTO memberDTO-회원가입에 필요한 data
		//리턴 int - 입력성공시 1을 반환
		int insertedRows = memberServiceImpl.insertMember(memberDTO);
		
		//3.Model
		//4.View
		if(insertedRows==1) {//회원가입성공시 회원목록페이지로 이동
			mv.setViewName("redirect:/member/list");
		}else{//회원가입실패시 가입폼 페이지로 이동
			mv.setViewName("redirect:/member/join");
		}
		return mv;
	}
	
}

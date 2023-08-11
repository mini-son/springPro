package com.mycom.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.member.domain.MemberDTO;
import com.mycom.member.domain.User;
import com.mycom.member.service.MemberService;
import com.mycom.member.service.MemberServiceImpl;

//Controller->Service->DAO(repository)->myBatis->DB
@Controller
@RequestMapping("/member")
public class MemberController {
	//필드
	@Autowired
	private MemberService memberService;
	
	//생성자
	//메서드
	//전체회원수 조회
	//요청주소 http://localhost:8081/app/totalMember
	//get방식
	@RequestMapping("/totalMember")
	public void  getTotalMemberCNT(Model model) throws Exception {
		//1.파라미터받기
		//2.비지니스로직<->Service<->DAO(repository)<->myBatis<->DB
		int totalMemberCNT = memberService.getTotalMemberCNT();
		
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
																		@RequestParam("mid") String memberid) throws Exception {
		//파라미터받기 - 회원id
		//String memberid=request.getParameter("mid");
		
		//2.비지니스로직<->Service<->DAO(Repository)<->myBatis<->DB
		MemberDTO memberDTO = memberService.getMemberById(memberid);
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
	public void getMemberList(Model model) throws Exception {
		/*리턴 List<HashMap<String,Object>>
		HashMap은 Key, Value를 필요로 한다.
		이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
		예) 컬럼명 no,memberid,password,name,regdate,isshow
		예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
		Key no에는 숫자타입2가 저장
		Key memberid에는 문자타입 hongid가 저장
		한명의 회원 정보는 HashMap저장.
		다수의 회원정보들이므로 List에 넣어줬다.*/
		List<HashMap<String, Object>> memberlist = memberService.getMemberList();
		model.addAttribute("memberlist", memberlist);
		
		//return "/member/list";
	}
	
	//수정-수정폼보여주기요청=>get방식
	//요청주소 http://localhost:8081/app/member/modify
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public ModelAndView modifyFormMember(ModelAndView mv,HttpSession session) throws Exception{
		//1.파라미터받기 mid=회원id
		//로그인한 회원의 id가 작성자와 일치하면 수정가능하다.
		//여기에서는 로그인했다고 가정하고 진행
		User user = new User( "hongid", "홍GD","의적");
		session.setAttribute("AUTH_USER", user);
	/*session.setAttribute("AUTH_USERID", "hongid");
		session.setAttribute("AUTH_USERNAME", "홍GD");
		session.setAttribute("AUTH_USER_NICKNAME", "의적");*/
		user = (User)session.getAttribute("AUTH_USER");//여기에서는 로그인한 user라고 가정하고 진행
		String memberid = user.getId();
		//위의 코드를 아래와 같이 한 줄로 작성할 수 있다.
		//String memberid = ((User)session.getAttribute("AUTH_USER")).getId();
		
		//2.비지니스로직
		MemberDTO memberDTO = memberService.getMemberById(memberid);
		System.out.println(memberDTO);
		
		//3.Model
		mv.addObject("memberDTO",memberDTO);
		
		//4.View
		mv.setViewName("/member/modifyForm");
		return mv;
	}

	//수정처리=>post방식
	//요청주소 http://localhost:8081/app/member/modify
/*memberDTO로 받았을 때
 	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public void modifyMember(MemberDTO memberDTO){
			//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
			System.out.println(memberDTO);
			
			//2.비지니스로직
			//3.Model
			//4.View
	}*/
	//Map으로 받았을 때
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modifyMember(@RequestParam Map<String,Object> map,ModelAndView mv) throws Exception{
		//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		System.out.println("map.get(no):"+map.get("no"));
		System.out.println("map.get(memberid):"+map.get("memberid"));
		System.out.println("map.get(name):"+map.get("name"));
		System.out.println("map.get(password):"+map.get("password"));
		
		//2.비지니스로직
		/*파라미터:form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		회원번호의  key는 "no			회원id의  key는 "memberid"
		회원명의 key는 "name"		회원명의  key는 "password" */
		//리턴 int - 수정성공시 1을 반환
		int resultInt = memberService.modifyMember(map);
		
		//3.Model
		//4.View
		if(resultInt==1) {//수정성공시 회원목록페이지로 이동
			mv.setViewName("redirect:/member/list");
		}else{//수정성공시 수정폼 페이지로 이동
			mv.setViewName("redirect:/member/modify");
		}
		return mv;
	}
	
	//삭제
	//요청주소 http://localhost:8081/app/member/delete?mid=회원id
	@RequestMapping("/delete")
	public ModelAndView deleteMember(ModelAndView mv,
									@RequestParam("mid") String mid) throws Exception  {
		//1.파라미터받기 mid=회원id
		//2.비지니스로직
		//파라미터  String mid-삭제하고 싶은 회원id
		//리턴 int - (update용)회원삭제 성공하면 1을 반환
		int rowCnt = memberService.deleteMember(mid);
		
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
	public ModelAndView join(ModelAndView mv,MemberDTO memberDTO) throws Exception{
		//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,id,이름,비번 등
		System.out.println(memberDTO);
		
		//2.비지니스로직
		//파라미터 MemberDTO memberDTO-회원가입에 필요한 data
		//리턴 int - 입력성공시 1을 반환
		int insertedRows = memberService.insertMember(memberDTO);
		
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

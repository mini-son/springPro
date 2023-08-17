package com.mycom.main;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.member.service.MemberService;

//웹어플리케이션의 메인용컨트롤러
@Controller
public class MainController {

	//필드
	@Autowired
	private MemberService memberService;
	
	//요청주소 ${cPath}/main
	@RequestMapping("/main")
	public String main(Model model,@RequestParam HashMap<String,Object> map) throws Exception {
		System.out.println("메인컨트롤러 진입,tiles적용중");
		//1. 파라미터받기
		//2. 비지니스로직수행
		//회원목록조회
		List<HashMap<String, Object>> memberlist = memberService.getMemberList(map);
		//3. Model
		model.addAttribute("memberlist", memberlist); //회원목록
		
		//4. View
		/*return "definition요소의 name속성명"
		 * servlet-context.xml문서에서 설정한
		 * classpath:tile/*.xml부분에 명시된 tiles_main.xml문서에서 선언한 아래코드를 반영하였다.
		 * 	<definition name="/main" extends="baseLayout">
					<put-attribute name="body" value="/WEB-INF/views/main.jsp"/>
				</definition>*/
		return "/main";
	}
	
}

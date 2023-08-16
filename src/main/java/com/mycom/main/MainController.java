package com.mycom.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//웹어플리케이션의 메인용컨트롤러
@Controller
public class MainController {

	//필드
	
	//요청주소 ${cPath}/main
	@RequestMapping("/main")
	public String main() {
		System.out.println("메인컨트롤러 진입");
		//1. 파라미터받기
		//2. 비지니스로직수행
		//3. Model
		//4. View
		return "baseLayout";
	}
	
}

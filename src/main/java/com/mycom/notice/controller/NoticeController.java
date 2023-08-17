package com.mycom.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//이 클래스는 공지사항 관련 컨트롤러이다.
@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	//공지사항목록보기
	//요청방식 : get
	//요청주소 : http://localhost:8081/app/notice/list
	@GetMapping("/list")
	public String noticeList() {
		System.out.println("공지사항목록보기-noticeList()진입");
		return "/notice/List";
	}
	
	//상세보기
	//요청주소 : http://localhost:8081/app/notice/detail/101
	@GetMapping("/detail/{no}")
	public String getDetail(@PathVariable int no,Model model) {
		//1.파라미터받기 : 요청경로에서 넘어오는 값을 @PathVariable을 이용하여 int타입 매개변수 no에 받았다. 
		//2.비지니스로직수행
		//3.Model
		model.addAttribute("no", no);
		//4.View
		return "/notice/Detail";
	}
	
}

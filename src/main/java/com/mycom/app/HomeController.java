package com.mycom.app;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping("/a")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//-- 요청매핑-----------------------------------------------
		/*RequestMapping(value = "요청경로", 
		                 method = RequestMethod.GET 또는 
		                 	      RequestMethod.POST 또는
		                 	      RequestMethod.DELETE 또는
		                 	      RequestMethod.PUT 등,
		                ) 	      
	            요청경로만 작성시에는 value=  부분이 생략가능
	            
	           아래는 GET방식요청과 POST요청 둘 다 허용시       
	     method = {RequestMethod.GET,RequestMethod.POST}    
	            
	     method = RequestMethod.GET=> @GetMapping("경로")  
	     method = RequestMethod.POST=> @POSTMapping("경로")  
	     method = RequestMethod.DELETE=> @DeleteMapping("경로")  
	     method = RequestMethod.PUT=> @PutMapping("경로")  
	     */
		@GetMapping(value="/test1")
		//@PostMapping(value="/test1")
		//@DeleteMapping(value="/test1")
		//@PutMapping(value="/test1")
		public String mappingtest() {
			logger.info("mappingtest()호출");
			return "paramTest"; //paramTest.jsp없어서  404발생
		}
		
		//요청주소 http://localhost:8081/app/mt0
		//요청주소 http://localhost:8081/app/mt1
		//요청주소 http://localhost:8081/app/mt2
		@RequestMapping(value= {"/mt0","/mt1","/mt2"})
		public String mappingtest2() {
			logger.info("mappingtest()호출");
			return "paramTest"; //paramTest.jsp없어서  404발생
		}
	
	
	//-- 파라미터받기-----------------------------------------------
	//요청주소  http://localhost:8081/app/test?id=hongid&age=12
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("id") String rpid,
			@RequestParam("age") int rpage) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//1.파라미터받기- 기존의 방식을 이용
		/*String 변수명 = request.getParameter("파라미터명");
		  리턴유형이 String이었으므로 필요시 형변환을 해야했다.*/
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("syso 파라미터id="+id);
		System.out.println("syso 파라미터age="+(age-1));
		
		//1.파라미터-요청메서드안의 매개변수로 @RequestParam("파라미터명") 타입  매개변수명
		//매개변수의 타입을 자유롭게 지정할 수 있어 편리하다
		//@RequestParam("age") int rpage는 ?age=12라는 파라미터명이 age인 값을 받아서 int타입 변수 rpage에 저장
		logger.info("@RequestParam(id)는 {}",rpid); //콘솔
		logger.info("@RequestParam(age)는 {}",rpage-1);//콘솔
		
		//2.비즈니스로직
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		//3.Model
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("name", "홍GD");
		
		//org.springframework.ui패키지의 Model이용
		model.addAttribute("serverTime", formattedDate );
		
		//4.view
		return "home";
	}
	
	//요청주소  http://localhost:포트번호/컨페/form01
	//요청주소  http://localhost:8081/app/form01
	//view  /WEB-INF/views/form01.jsp
	@RequestMapping("/form01")
	public String form01() {
		//1.파라미터받기
		//2.비즈니스로직
		//3.Model
		//4.View
		return "form01";
	}
	
	//요청방식  post
	//요청주소  http://localhost:8081/app/form01Result
	//view  /WEB-INF/views/form01Result.jsp
	/*@RequestParam(value="파라미터명", 
	 *              required=false또는true(기본값),
	 *              defaultValue="기본값") 데이터타입 매개변수명
	 *파라미터명과 매개변수명이 동일하면         value="파라미터명" 생략가능
	 *null데이터를 int로 받는 경우에는 400에러발생하므로
	 *  defaultValue="기본값"을 명시해야 한다 
	 *  
	 *매개변수의 타입을 Class를 이용할 수 있다.
	 *여기에서는  TestDTO타입의  매개변수testDTO
	 *단, Class가 미리준비되어야 한다((기본생성자,)setter필히 있어야 한다)
	 * */
	@RequestMapping(value="/form01Result",method=RequestMethod.POST)
	public String form01Result(
			@RequestParam String userName,
			@RequestParam("hobby") String[]  hobbies,
			@RequestParam(defaultValue="all") String search,
			@RequestParam(defaultValue="")  String keyword,
			@RequestParam(required=false,defaultValue="1") int pageNo,
			TestDTO  testDTO) {
		//1.파라미터받기
		logger.info("testDTO:{}", testDTO);//콘솔
		
		logger.info("이름:{}", userName);
		logger.info("관심사:{}", hobbies);
		for( String h: hobbies) {
			System.out.println(h);
		}
		logger.info("검색분야:{}, 검색어:{}", search, keyword);
		logger.info("페이지번호:{}", pageNo);
		
		
		//2.비즈니스로직
		//3.Model
		//4.View
		return "form01Result"; //   WEB-INF/views폴더안에  form01Result.jsp를 만들지 않았으므로 404에러가 뜬다
	}
	
	//요청주소 http://localhost:포트번호/컨페/paramTest
	//요청주소 http://localhost:8081/app/paramTest?name=홍&pw=1234
	@RequestMapping("/paramTest")
	public String paramTest(@RequestParam Map<String,Object> paramMap) {
		//Map참조변수명.put(Object키명, Object값)
		//Map참조변수명.get(Object키명)
		
		logger.info("파람name:{}, 파람pw:{}", paramMap.get("name"), paramMap.get("pw"));
		return "paramTest"; //paramTest.jsp없어서  404발생
	}
	
	//요청주소 http://localhost:포트번호/컨페/paramTest2
	//요청주소 http://localhost:8081/app/paramTest2?name=홍1&name=HONG2&name=이순신
	@RequestMapping("/paramTest2")
	public String paramTest2(@RequestParam() List<String> name,
			HttpServletRequest req,
			HttpServletResponse res) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		//List참조변수명.add(Object값)
		//Object 값=List참조변수명.get(인덱스번호)
		
		//List참조변수명.add(String값)
		//String 값=List참조변수명.get(인덱스번호)
		for(String n : name) {
			logger.info("파람name:{}", n);
		}
		return "paramTest"; //paramTest.jsp없어서  404발생
	}
	
	//요청주소 http://localhost:8081/app/board/hongid/silver/List/1
	//요청주소 http://localhost:8081/app/board/kimid/green/List/99
	//요청주소 http://localhost:8081/app/board/leeid/vip/List/100
	@RequestMapping("/board/{userId}/{grade}/List/{no}")
	public String paramTest3(@PathVariable String userId,
			@PathVariable String grade,
			@PathVariable int no) {
		logger.info("@PathVariable  userId:{}, grade:{}", userId,grade);
		logger.info("@PathVariable  no:{}", no*99);
		return "paramTest"; //paramTest.jsp없어서  404발생
	}
	
	//-- Model --------------------------------------------
	//요청주소 http://localhost:8081/app/modelTest1
	/*방법1.
	 	매개변수에 Model인터페이스타입의 참조변수 선언 후 
	 	요청메서드 내부에서 참조변수명.addAttribute(String속성명, Object값); 하여
	 	view에게 model전달하는 방식
	 	
	 	방법2.
	 	매개변수에 @ModelAttribute("속성명") 타입 매개변수명 선언하여
	 	view에게 model전달하는 방식	 	*/
	@RequestMapping("/modelTest1")
	public String modelTest1(
						HttpServletRequest req,
						HttpSession session,
						Model model,
						@ModelAttribute("am5") TestDTO t) {
		logger.info("modelTest1() 호출");
		
		//방법2.
		t.setUserName("@모델attribute에서 설정한 유저명");
		
		//HttpSession session = req.getSession();
		req.setAttribute("m1", "HttpServletRequest객체이용");
		session.setAttribute("m2", "HttpSession객체이용");
		
		//방법1.
		//model.addAttribute(String속성명, Object값);
		model.addAttribute("am3", "스프링프레임워크의 Model객체이용");
		
		TestDTO testDTO = new TestDTO();
		testDTO.setUserName("강감찬");
		List<String> hobbyList = new ArrayList<>();
		hobbyList.add("영화보기");
		hobbyList.add("독서");
		hobbyList.add("음악감상");
		hobbyList.add("유튜브보기");
		testDTO.setHobby(hobbyList);
		testDTO.setPageNo(150);
		testDTO.setSearch("title");
		testDTO.setKeyword("태풍");
		model.addAttribute("am4",testDTO);
		//속성명은 model값의 타입으로 사용되는 bean과 동일할 때에는 생략할 수 있다.
		model.addAttribute(testDTO);
		
		return "modelTest1";
	}
	
	//-- Model --------------------------------------------
	//요청주소 http://localhost:8081/app/modelViewTest1
	@RequestMapping("/modelViewTest1")
	public ModelAndView modelViewTest1(ModelAndView mv) {
		//ModelAndView mv = new ModelAndView();
		mv.addObject("mav1","Object타입가능~"); //Model작업
		mv.setViewName("modelViewTest1");//View지정
		return mv;
	}

	//요청주소 http://localhost:8081/app/modelViewTest2
	@RequestMapping("/modelViewTest2")
	public ModelAndView modelViewTest2(ModelAndView mv) {
		//ModelAndView mv = new ModelAndView();
		mv.addObject("mav2","수업중"); //Model작업
		
		//ModelAndView참조변수명.setViewName("redirect:요청주소")
		//요청주소로 요청->해당 요청메서드에서 지정한 view가 user에게 보여진다.
		mv.setViewName("redirect:/form01");
		return mv;
	}
	
	//요청주소 http://localhost:8081/app/modelViewTest3
	@RequestMapping("/modelViewTest3")
	public ModelAndView modelViewTest3(ModelAndView mv,HttpServletRequest req) throws UnsupportedEncodingException {
		//ModelAndView mv = new ModelAndView();
		mv.addObject("mav3","haha"); //Model작업
		
		//ModelAndView참조변수명.setViewName("redirect:요청주소")
		//요청주소로 요청->해당 요청메서드에서 지정한 view가 user에게 보여진다.
		req.setCharacterEncoding("utf-8");
		mv.setViewName("redirect:/paramTest2?name=hong1&name=HONG2&name=lee");
		return mv;
	}
}














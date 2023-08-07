<%-- 
	<%@ %>은 지시어(directive)부분
	<%@ page %>  page directive.페이지지시어
							 jsp페이지에 대한 정보를 지정.
							 jsp페이지가 생성하는 문서의 타입,에러페이지 등 jsp페이지에서 필요로 하는 정보 설정
    --%>
<%@ page import="java.util.Enumeration" %>        
<%@ page import="java.util.Map" %>        
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%	//요청 파라미터의 	CharacterEncoding을 UTF-8로 지정.
	//한글을 올바르게 처리하기 위함.
	//request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>viewParameter_p77.jsp</h2>
<%
	out.println("<h3>**request.getParameter()이용 결과-------</h3>");
	//<input type="text"  name="userName" />
	String userName = request.getParameter("userName");
	out.println("유저가 입력한 userName =<u>"+userName+"</u><br/>"); //콘솔출력
	
	//hobby=coffee&hobby=movie&hobby=darama&hobby=toon
 /*<input type="checkbox" name="hobby" id="h0" value="coffee"  checked="checked"/><label for="h0">커피내리기</label>
   <input type="checkbox" name="hobby" id="h1" value="movie"/><label for="h1">영화감상</label>*/
	
	out.println("<h3>**request.getParameterValues()이용 결과-------</h3>");
    String[] hobby  = request.getParameterValues("hobby");
	if(hobby!=null){		
		for(String data : hobby){
			out.println(data+"<br/>");
		}
	}
	
	out.println("<h3>**request.getParameterNames()이용 결과-------</h3>");
	Enumeration<String> names = request.getParameterNames();
	while(names.hasMoreElements()){
		String name = names.nextElement();
		out.println(name+"<br/>");
	}
	
	out.println("<h3>**request.getParameterMap()이용 결과-------</h3>");
	Map<String, String[]> map = request.getParameterMap();
	Enumeration<String> names1 = request.getParameterNames(); //이름들 가져오기
	while(names1.hasMoreElements()){
		String name = names1.nextElement();
		String[] values = map.get(name);//Map에서 가져온 이름을 이용하여 value가져오기 
		for(String value : values){
			out.println(name+"의 값은 "+value+"<br/>");
		}
	}
%>	
</body>
</html>








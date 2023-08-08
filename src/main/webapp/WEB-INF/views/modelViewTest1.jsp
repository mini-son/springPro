<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>modelViewTest1.jsp</h2>
	mv.addObject("mav1","Object타입가능");
	<ul>
		<li>mv.addObject("mav1"):${mav1}</li>
	</ul>
</body>
</html>
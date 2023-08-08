<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>modelTest1.jsp</h2>
	<ul>
		<li>	req.setAttribute("m1")의 값:${m1}</li>
		<li>session.setAttribute("m2")의 값:${m2}</li>
		<li>----------------</li>
		<li>model.addAttribute("am3"):${am3}</li>
		<li>model.addAttribute("am4"):${am4}</li>
		<li>model.addAttribute(testDTO)의 값:${testDTO}</li>
		<li>model.addAttribute("am5"):${am5}<br/>
						am5.getUserName()의 값:${am5.getUserName()}<br/>
						am5.userName의 값:${am5.userName}
		</li>
	</ul>
</body>
</html>
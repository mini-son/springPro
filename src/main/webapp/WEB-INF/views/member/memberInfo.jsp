<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberInfo.jsp</h1>
	<%-- model.addAttribute("memberDTO",memberDTO);--%>
	memberDTO=${memberDTO}<hr/>
	  <table id="memberTable" border="1">
    <tbody>   
      <tr>
        <th>번호</th><td>${memberDTO.no}</td>
      </tr>
      <tr>
        <th>아이디</th><td>${memberDTO.memberid}</td>
      </tr>
      <tr>
        <th>이름</th><td>${memberDTO.name}</td>
      </tr>
      <tr>
        <th>가입일</th><td>${memberDTO.regDate}</td>
      </tr>
      <tr>
        <th>비번</th><td>${memberDTO.password}</td>
      </tr>
      <tr>
        <th>isshow</th><td>${memberDTO.isshow}</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
</body>
</html>
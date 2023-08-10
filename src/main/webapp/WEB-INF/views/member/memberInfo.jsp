<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
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
        <th>가입일</th><td><fmt:formatDate value="${memberDTO.regDate}" pattern="yyyy.MM.dd HH:mm:ss"/></td>
      </tr>
      <tr>
        <th>비번</th><td>${memberDTO.password}</td>
      </tr>
      <tr>
        <th>isshow</th><td>${memberDTO.isshow}</td>
      </tr>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/member/list">목록보기</a>
      		<a href="${cPath}/member/modify?mid=${memberDTO.memberid}">수정(폼페이지 보여줘)</a>
      		<a href="${cPath}/member/delete?mid=${memberDTO.memberid}">삭제</a>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- jQuery연동 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//<input type="button" id="joinBtn" value="가입"/>
	$("#joinBtn").on("click",function(){
		let memberObjV = $("#memberid").val();
		if(memberObjV==""){
			alert("id필수입력입니다");
			$("#memberid").focus();
			return;
		}
		
		let nameObjV = $("#name").val();
		if(nameObjV==""){
			alert("name필수입력입니다");
			$("#name").focus();
			return;
		}
		
		let passwordObjV = $("#password").val();
		if(passwordObjV==""){
			alert("password필수입력입니다");
			$("#password").focus();
			return;
		}
		
		$("#memberJoinForm").submit();
	});
});
</script>
</head>
<body>
<pre>http://localhost:8081/app/member/join</pre>
	<h1>join.jsp</h1>
	
	<form id="memberJoinForm" action="join" method="POST">
	  <table id="memberJoinTable" border="1">
    <tbody>   
      <tr>
 		 <%-- <th>번호</th>
        <td><input type="">${memberDTO.no}</td>
      </tr> --%>
      <tr>
        <th>아이디</th>
        <td><input type="text" name="memberid" id="memberid" required="required"/></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input type="text" name="name" id="name" required="required"/></td>
      </tr>
      <tr>
        <th>비번</th>
        <td><input type="text" name="password" id="password" required="required"/></td>
      </tr>
      <%--<tr>
        <th>isshow</th><td>${memberDTO.isshow}</td>
      </tr>--%>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/member/list">목록보기</a>
      		<input type="button" id="joinBtn" value="가입"/>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
  </form>
</body>
</html>
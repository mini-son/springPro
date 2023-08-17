<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@  taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="site.title" text="Member JOIN"/></title>
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
<br/><br/>
<a href="${cPath}/member/join.do?locale=ko">한국어</a> | <a href="${cPath}/member/join.do?locale=en">ENGLISH</a>
<hr/><br/><br/>
<pre>http://localhost:8081/app/member/join</pre>
	<%-- <spring:message code="properties의 KEY명" text="태그미적용시 사용되는 기본text"/>--%>
	<h1><spring:message code="site.title2" text="--"/>(join.jsp)</h1>
	
	<form id="memberJoinForm" action="join" method="POST">
	  <table id="memberJoinTable" border="1">
    <tbody>   
      <tr>
 		 <%-- <th>번호</th>
        <td><input type="">${memberDTO.no}</td>
      </tr> --%>
      <tr>
        <th><spring:message code="site.id" text="--"/></th>
        <td><input type="text" name="memberid" id="memberid" required="required"/></td>
      </tr>
      <tr>
        <th><spring:message code="site.name" text="--"/></th>
        <td><input type="text" name="name" id="name" required="required"/></td>
      </tr>
      <tr>
        <th><spring:message code="site.pw" text="--"/></th>
        <td><input type="password" name="password" id="password" required="required"/></td>
      </tr>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/member/list"><spring:message code="btn.list" text="list"/></a>
      		<input type="button" id="joinBtn" value="<spring:message code="btn.join" text="JOIN"/>"/>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
  </form>
</body>
</html>
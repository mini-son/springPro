<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<!-- jQuery연동 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//<input type="button" id="modifyBtn" value="수정"/>
	$("#modifyBtn").on("click",function(){
		
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
		
		$("#memberModifyForm").submit();
	});
});
</script>
</head>
<body>
<pre>http://localhost:8081/app/member/modify</pre>
	<h1>modifyForm.jsp</h1>
	memberDTO=${memberDTO}
	<form id="memberModifyForm" action="modify" method="POST">
		<input type="hidden" name="no" value="${memberDTO.no}"/>
	  <table id="memberModifyTable" border="1">
    <tbody>   
      <tr>
 		  <th>번호</th>
        <td>${memberDTO.no}</td>
      </tr>
      <tr>
        <th>아이디</th>
        <%--readonly속성은 읽기전용(수정불가),서버로 submit된다(cf>disabled속성은 서버로 submlt 안됨) --%>
        <td><input type="text" name="memberid" id="memberid" readonly="readonly" value="${memberDTO.memberid}"/></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input type="text" name="name" id="name" required="required" value="${memberDTO.name}"/></td>
      </tr>
      <tr>
        <th>비번</th>
        <td><input type="password" name="password" id="password" required="required"/></td>
      </tr>
      <tr>
        <th>isshow</th>
        <td>${memberDTO.isshow}</td>
      </tr>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/member/list">목록보기</a>
      		<input type="button" id="modifyBtn" value="수정"/>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
  </form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
</head>
<body>
	<h1>list.jsp</h1>
	<%--		/*리턴 List<HashMap<String,Object>>
		HashMap은 Key, Value를 필요로 한다.
		이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
		예) 컬럼명 no,memberid,password,name,regdate,isshow
		예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
		Key no에는 숫자타입2가 저장
		Key memberid에는 문자타입 hongid가 저장
		한명의 회원 정보는 HashMap저장.
		다수의 회원정보들이므로 List에 넣어줬다.*/
		List<HashMap<String, Object>> memberlist = memberServiceImpl.getMemberList();
		model.addAttribute("memberlist", memberlist); --%>
		memberlist=${memberlist}
		<form id="searchForm" action="${cPath}/member/list" method="get">
			<input type="text" placeholder="검색어 입력" name="keyword" />
			<input type="submit" value="검색"/>
		</form>
	 <table id="memberTable" border="1">
    <thead>   
      <tr>
        <th>번호</th>
        <th>아이디</th>
        <th>이름</th>
        <th>가입일</th>
        <th>isshow</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
    <%--회원이 존재하지 않는 경우 --%>
    <c:if test="${empty memberlist}">
    	<tr>
    		<td colspan="6">존재하는 회원이 없습니다.</td>
    	</tr>
    </c:if>
    <%--회원이 존재하는 경우 회원수만큼 반복 출력 --%>
    <%--회원목록은 List로, 1명의 회원은 HashMap으로, 1명 회원의 값은 HashMap의 Key로 접근 --%>
     <c:if test="${not empty memberlist}">
     	<c:forEach var="row" items="${memberlist}">
    <%--변수row에는 1명 회원의 정보가 HashMap으로 저장되어있다 --%>
    	<tr>
	    		<td>${row.no}</td>
	        <td><a href="${cPath}/member/getMember?mid=${row.memberid}">${row.memberid}</a></td>
	        <td>${row.name}</td>
	        <td>${row.regdate}</td>
	        <td>${row.isshow}</td>
	        <td>${row.memberid}</td>
	        <td>삭제</td>
    	</tr>
    	</c:forEach>
    </c:if>
    </tbody>
  </table>
  
	<button type="button" id="joinBtn" onclick="location.href='${cPath}/member/join'">회원가입</button>
</body>
</html>
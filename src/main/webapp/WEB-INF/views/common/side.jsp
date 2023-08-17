<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>

<nav>
	<ul>
		<%--<c:choose><when test="로그인했으면 보여주는 부분">시작
0	   <li><a href="#">비번변경</a></li>
	   <li><a href="#">정보수정</a></li>
	   <li><a href="#">메뉴</a></li>
	   </c:choose> 끝--%>
	   <%--<c:otherwise>시작
	   <li><a href="#">로그인</a></li>
	   <li><a href="#">회원가입</a></li>
	   <%--<c:otherwise>끝 --%>
	   <li><a href="${cPath}/notice/list">공지사항</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	   <li><a href="#">메뉴</a></li>
	</ul>
</nav>
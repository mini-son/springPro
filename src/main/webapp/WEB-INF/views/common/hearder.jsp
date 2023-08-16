<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath"  value="<%=request.getContextPath()%>"/>    
    
<div id="logo">
	<a href="${cPath}/main">
 <img width="72px"  height="62px" alt="회사로고" src="${cPath}/resources/image/logo.jpg" />	
	</a>
</div>    
<div id="head_link">
	<ul>
		<%-- <c:choose> <when test="로그인했으면 보여주는부분">시작
	   <li><a href="#">로그아웃</a></li>
	   <li><a href="#">MyPage</a></li>
	   </c:choose> 끝--%>
	   <%-- <c:otherwise>시작 --%>
	   <li><a href="#">로그인</a></li>
	   <li><a href="#">회원가입</a></li>
	   <%-- <c:otherwise>끝 --%>
	   <li><a href="#">SITEMAP</a></li>
	</ul>
</div>    

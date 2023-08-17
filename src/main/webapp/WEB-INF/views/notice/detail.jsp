<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>

<h2>notice(detail.jsp)화면</h2>
<%-- model.addAttribute("no", no); --%>
<p>${no}번 게시글의 상세내용</p>
tiles적용중
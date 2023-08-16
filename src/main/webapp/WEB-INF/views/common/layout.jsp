<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${cPath}/resources/css/main.css">
<title></title>
</head>
<body>
	<div id="outer_wrap">
	 <div id="wrap">
	 	<header>
	 			<tiles:insertAttribute name="header"/>
	 	</header>
		<div class="clear"></div>
		<aside>
				<tiles:insertAttribute name="side"/>
		</aside>
		<div class="clear"></div>
		<article>
				<tiles:insertAttribute name="body"/>
		</article>
		<div class="clear"></div>
		<footer>
				<tiles:insertAttribute name="footer"/>
		</footer>
	 </div>
	</div>
</body>
</html>
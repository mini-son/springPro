<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터 관련 메서드</title>
</head>
<body>
 <h2>스프링에서의 파라미터받기</h2>
 현재주소 http://localhost:8081/app/form01
 <form id="frm1" action="form01Result" method="get">
 	*이름: 
 	<input type="text"  name="userName"        id="userName" 
	   	   size="10"    autofocus="autofocus"  placeholder="이름입력하세요"/>
 	<br/>
 	
 	*관심사(취미): <%-- hobby=coffee&hobby=movie&hobby=darama --%>
    <input type="checkbox" name="hobby" id="h0" value="coffee"  checked="checked"/><label for="h0">커피내리기</label>
    <input type="checkbox" name="hobby" id="h1" value="movie"/><label for="h1">영화감상</label>
    <input type="checkbox" name="hobby" id="h2" value="darama"/><label for="h2">드라마보기</label>
    <input type="checkbox" name="hobby" id="h3" value="toon"/><label for="h3">웹툰보기</label> 
    <input type="checkbox" name="hobby" id="h4" value="music"/><label for="h4">음악감상</label>  
    <input type="checkbox" name="hobby" id="h5" value="book"/><label for="h5">독서</label>
	<br/>
	
	*hidden:
	<input type="hidden" name="pageNo" value="100"/><br/>
	
	*선택: <%--keyword=writer --%>
	<select name="search" id="search">
		<option value="">선택</option>
		<option value="title">제목</option>
		<option value="content">내용</option>
		<option value="writer">작성자</option>
	</select>
	<input type="text" name="keyword" id="keyword"/>
	<br/><br/>	
	
	<input type="submit" value="전송" />
	<input type="reset"  value="취소" />
 </form>
 
 
 <pre>
 
 

 
 
 
 
*form요소의  속성
 -action: 서버(server)측 페이지
 -method: get(기본값) | post

*GET에 대한 참고 사항:
 -양식 데이터를 이름/값 쌍으로 URL에 추가합니다.
 -GET을 사용하여 민감한 데이터를 보내지 마십시오! (제출된 양식 데이터는 URL에서 볼 수 있습니다!)
 -URL의 길이는 제한되어 있습니다(2048자).
 -사용자가 결과를 북마크하려는 양식 제출에 유용합니다.
 -GET은 Google의 쿼리 문자열과 같은 비보안 데이터에 적합합니다.

*POST에 대한 참고 사항:
 -HTTP 요청 본문 내부에 양식 데이터를 추가합니다(제출된 양식 데이터는 URL에 표시되지 않음).
 -POST는 크기 제한이 없으며 많은 양의 데이터를 보내는 데 사용할 수 있습니다.
 -POST를 사용한 양식 제출은 북마크할 수 없습니다.
</pre>	
</body>
</html>
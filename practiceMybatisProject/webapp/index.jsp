<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	index.jsp 테스트
	
	<!-- index페이지 로딩되자마자 WEB-INF/views/main.jsp로 포워딩 -->
	<jsp:forward page="WEB-INF/views/main.jsp" />
</body>
</html>
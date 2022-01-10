<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.login-area a{
		text-decoration: none;
		color: black;
		font-size: 12px;
	}
	.nav-area{
		background-color: black;
		color: white;
		height: 50px;
	}
	.menu{
		display: table-cell;
		width: 250px;
		height: 50px;
		vertical-align: middle; /*블럭요소일 때 가능*/ 
		font-size: 20px;
		font-weight: bold;
	}
	.menu:hover{
		background-color: darkgray;
		cursor: pointer;
	}

	/*공통적으로 들어갈 css*/
	.outer{
		width: 900px;
		background-color: black;
		color: white;
		margin: auto;
		margin-top: 50px;
	}
</style>
</head>
<body>
	
	<h1 align="center">Welcome to MyBatis World</h1>
	<br>
	
	<div class="login-area" align="right">
		
		<c:choose>
			
			<c:when test="${ empty loginUser }">		
				<!-- case 1. 로그인 전 -->
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input type="text" name="userId" required></td>
							<td rowspan="2"><button type="submit" style="height: 50px;">로그인</button></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="enrollForm.me">회원가입</a> <!-- views 폴더가 webapp 폴더안에 들어온 순간, 뷰에 대한 경로를 알고있어도 무조건 서블릿거쳐서 포워딩을 해야함!! --> <!-- 상대경로방식 : 마지막 슬래쉬 뒤에 해당 요소가 붙어서 나옴 -->
								<a href="">아이디/비번찾기</a>
							</td>
						</tr>
					</table>
		
				</form>
			</c:when>
			<c:otherwise>
				<!-- case 2. 로그인 후 -->
				<div>
					<table>
						<tr>
							<td colspan="2">
								<h3>${ loginUser.userName }님 환영합니다.</h3>
							</td>
						</tr>
						<tr>
							<td><a href="">마이페이지</a></td>
							<td><a href="">로그아웃</a></td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>

	</div>
	
	<br>

	<div class="nav-area" align="center">
		<div class="menu">HOME</div>
		<div class="menu">공지사항</div>
		<div class="menu" onclick="location.href='list.bo?cpage=1';">게시판</div>
		<div class="menu">ETC</div>
	</div>
	
	
</body>
</html>
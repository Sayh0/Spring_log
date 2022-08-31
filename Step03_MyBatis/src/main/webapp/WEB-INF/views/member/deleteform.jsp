<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/deleteform.jsp</title>
</head>
<body>
	<h1>회원 삭제 폼</h1>
	<h2>삭제할 회원의 번호를 입력학세요</h2>
	<form action="${pageContext.request.contextPath }/member/delete.do" method="post">
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" id="num"/>
		</div>
		<button type="submit">삭제</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
		</thead>
		<tbod>
			<c:forEach var="tmp" items="${requestScope.list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
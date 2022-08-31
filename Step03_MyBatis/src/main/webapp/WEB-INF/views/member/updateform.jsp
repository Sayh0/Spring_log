<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/member/updateform.jsp</title>
</head>
<body>
<div class="container">
	<h1>회원 수정 폼</h1>
	<form action="${pageContext.request.contextPath }/member/update.do" method="post">
		<input type="hidden" name="num" value="${dto.num}"/> <!-- 번호도 받아와야 하기 때문에 hidden으로 받아옴 -->
		<div>
			<label for="num">번호</label>
			<input type="text" name="num" id="num" value="${requestScope.dto.num }" disabled/>
		</div>
		<div>
			<label for="name">이름</label>
			<input type="text" name="name" id="name" value="${dto.name }"/> <!-- requestScope. 는 생략 가능 -->
		</div>
		<div>
			<label for="addr">주소</label>
			<input type="text" name="addr" id="addr" value="${dto.addr }"/>
		</div>
		<button type="submit">수정</button>
	</form>
</div>
<div>
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
</div>
</body>
</html>
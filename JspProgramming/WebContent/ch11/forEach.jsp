<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		forEach.jsp
		<hr/>
		
		<c:forEach var="i" begin="1" end="5">
			${i}<br/>		
		</c:forEach>
		
		<hr/>
		<c:forEach var="i" begin="1" end="10" step="2">
			${i}<br/>		
		</c:forEach>
		<hr/>
		
		<%
		List<String> names=new ArrayList<String>();
		names.add("안세은");
		names.add("서가람");
		names.add("홍길동");
		request.setAttribute("names",names);
		%>
		
		<c:forEach var="i" items="${names}" varStatus="status" >
			status.first:${status.first},
			status.last:${status.last},
			status.index:${status.index},	
			status.count:${status.count},
			i:${i}<br/>		
		</c:forEach>
		
		<hr/>
		<c:forEach var="name" items="${names}" varStatus="status" >
			<c:if test="${status.first}">
				<ul>
			</c:if>
					<li>${name}</li>
			<c:if test="${status.last}">
				</ul>
			</c:if>
		</c:forEach>
	</body>
</html>
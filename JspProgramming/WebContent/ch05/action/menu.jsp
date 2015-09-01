<%@ page contentType="text/html; charset=UTF-8"%>

<%
int no = Integer.parseInt(request.getParameter("no"));
%>

<nav class="menu">
	<div class="menuitem <%=(no==1)?"selected":""%>">Menu1</div>
	<div class="menuitem <%=(no==2)?"selected":""%>">Menu2</div>
	<div class="menuitem <%=(no==3)?"selected":""%>">Menu3</div>
</nav>

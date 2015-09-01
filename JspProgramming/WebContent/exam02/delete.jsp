<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>
<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean id="productService" 
class="service.ProductService" 
scope="application">
</jsp:useBean>

<%
productService.remove(productNo);
response.sendRedirect("list.jsp");
%>
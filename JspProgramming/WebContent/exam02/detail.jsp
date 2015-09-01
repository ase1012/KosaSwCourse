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
//게시물 가져오기
Product product=productService.getProduct(productNo);
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				font-family: "돋움";
				font-size: 12px;
			}
			span{
				display:inline-block;
				margin:2px 10px;
			}
			span.title{
				margin:2px 10px;
				border:1px solid darkgray;
				background: lightgray;
				width:70px;
				text-align: center;
			}
			pre{
				margin:10px;
				border:1px solid darkgray;
				padding:10px;
				height:100px;
				width:300px;
				font-size: 12px;
			}
		</style>
	</head>
	
	<body>
		<h4>상품 보기</h4>
		<span class="title">번호 :</span>
		<span class="content"> <%=product.getNo()%></span><br/>
		<span class="title">상품이름 :</span>
		<span class="content"> <%=product.getName()%></span><br/>
		<span class="title">가격 :</span>
		<span class="content">  <%=product.getPrice()%></span><br/>
		<span class="title">재고 :</span> 
		<span class="content"> <%=product.getStock()%></span><br/>
		<span class="title">세부사항 :</span> <br/>
		<pre><%=product.getDetail()%></pre>
		
		<div id="buttonGroup">
			<a href="list.jsp"><img src="../common/images/board/list.gif"/></a>
			<a href="modify_form.jsp?product_no=<%=product.getNo()%>"><img src="../common/images/board/modify.gif"/></a>
			<a href="delete.jsp?product_no=<%=product.getNo()%>"><img src="../common/images/board/delete.gif"/></a>
		</div>
	</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>
<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean id="productService" 
class="service.ProductService" 
scope="application">
</jsp:useBean>
  
<%Product product=productService.getProduct(productNo);%>
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
			#content{
				width:300px;
				height:100px;
				margin-top: 20px;
				margin-left: 20px;
			}
		</style>
		<script type="text/javascript">
		function sendData(){
			//값의 유효성 검사
			//var modifyForm=document.querySelector("#modifyForm");
			var modifyForm =document.modifyForm;
			console.log(modifyForm);
			
			//var title=document.querySelector("#title");
			var price=document.modifyForm.price;
			console.log(price);
			
			var stock=document.modifyForm.stock;
			if(price.value==""||stock.value==""){
				alert("가격과 재고는 있어야 합니다.")
				return;
			}
			
			//서버로 전송
			modifyForm.submit();
		}
		</script>
	</head>
	
	<body>
		<h4>상품 수정</h4>
		<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
			<span class="title">번호 :</span>
			<span class="content"> <%=product.getNo()%></span>
			<input type="hidden" name="no" value="<%=product.getNo()%>"/>
			<br/>
			<span class="title">상품 이름 :</span>
			<span class="content">  <%=product.getName()%></span><br/>
			<span class="title">가격 :</span>
			<input id="title" type="number" name="price" value="<%=product.getPrice()%>"/><br/>
			<span class="title">재고 :</span> 
			<input type="number" name="stock" value="<%=product.getStock()%>"/><br/>
			<span class="title">세부사항 :</span> <br/>
			<div id="content"><%=product.getDetail() %></div>
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail.jsp?product_no=<%=product.getNo()%>">[취소]</a>
		</div>
	</body>
</html>
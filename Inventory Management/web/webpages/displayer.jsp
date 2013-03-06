<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:iterator status="stat" value="list">
<h6><s:property value="name"/> </h6> 
<h6><s:property value="id"/> </h6>
 

</s:iterator>
</body>
</html>
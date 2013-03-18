<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


    
<s:form action="item" method="POST">
<s:submit value="Go to item registration" align="center"/>
</s:form>
<s:form action="borrow" method="POST">
<s:submit value="Go to borrow" align="center"/>
</s:form>
<s:form action="return" method="POST">
<s:submit value="Go to return" align="center"/>
</s:form>
<s:form action="comment" method="POST">
<s:submit value="comment on item" align="center"/>


</s:form>
<s:form action="refresh" method="POST">
<s:submit value="refresh database" align="center"/>


</s:form>
    
 <s:form action="Logout" method="POST">
<s:submit value="logout" align="center"/>


</s:form>
</body>

</html>

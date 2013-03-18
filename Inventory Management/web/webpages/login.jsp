<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="Login"  method="POST">



<s:textfield name="userid" label="user id" />
<s:password name="password" label="password" />

          
<s:submit value="Login" align="center"/>

</s:form>

<s:form action="person" method="POST">
<s:submit value="Go to user registration" align="center"/>
</s:form>
<s:form action="refreshing" method="POST">
<s:submit value="refresh database" align="center"/>
</s:form>
</body>

</html>

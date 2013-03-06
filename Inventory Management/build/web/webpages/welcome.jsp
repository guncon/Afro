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
<s:form action="person" method="POST">
<s:submit value="Go to user registration" align="center"/>
</s:form>
<s:form action="borrowed" method="POST">
<s:submit value="Go to check in/out" align="center"/>
</s:form>
</body>

</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertComment"  method="POST">


<s:select list="itemid" name="itemid" label="item id"/>
<s:textfield name="comment" label="comment" size = "30"/>



          
<s:submit value="comment" align="center"/>

</s:form>

</body>

</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertData"  method="POST">



<s:textfield name="ID" label="item id" />
<s:textfield name="NAME" label="item name" />
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertData"  method="POST">



    <s:textfield name="ID" label="id" />
<s:textfield name="NAME" label="name" align = "center"/>
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertUser"  method="POST">




<s:select list="groupid" name="groupid" label="group ID"/>
<s:select list="permid" name="permid" label="permission ID" />
          
<s:submit value="Register" align="center"/>

</s:form>

</body>

</html>

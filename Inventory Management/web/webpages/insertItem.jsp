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
<s:select list="list" name="PRODID" />
<s:select list="list2" name="ITEMTYPEID" />
          
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

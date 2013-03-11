<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertData"  method="POST">



<s:textfield name="itemid" label="item id" />
<s:textfield name="itemname" label="item name" />
<s:select list="prodidlist" name="prodid" />
<s:select list="itemtypeidlist" name="itemtypeid" />
          
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

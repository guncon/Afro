<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertItem"  method="POST">



<s:textfield name="itemname" label="item name" />
<s:select list="prodidlist" name="prodid" label = "product ID"/>
<s:select list="itemtypeidlist" name="itemtypeid" label="item type ID" />
          
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

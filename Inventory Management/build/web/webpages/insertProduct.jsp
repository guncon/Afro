<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertProduct"  method="POST">



<s:textfield name="prodname" label="Name" />
<s:textfield name="proddesc" label="Product Description" />


          
<s:submit value="Save" align="center"/>

</s:form>

</body>

</html>

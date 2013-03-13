<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Struts 2 Insert Data Application!</title>

<link href="<s:url value="/css/main.css"/>" rel="stylesheet"
type="text/css"/>

</head>
<body>


<s:form action="insertBorrow"  method="POST">




<s:select list="userid" name="userid" label="USER ID"/>
<s:select list="itemid" name="itemid" label="ITEM ID" />
          
<s:submit value="Borrow" align="center"/>
 
</s:form>
    
  <s:form action="updateBorrow"  method="POST">




<s:radio list="borrower" name="userid" label="USER ID"/>
<s:radio list="borroweditem" name="itemid" label="ITEM ID" />
          
<s:submit value="Return" align="center"/>
 
</s:form>

</body>

</html>

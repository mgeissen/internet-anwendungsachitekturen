<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title><s:text name="header.application"/></title>
</head>
<body>
<h1><s:text name="header.application"/></h1>
<s:actionerror/>
<s:form action="sayhello">
    <p><s:text name="header.paragraph.name"/></p>
    <s:textfield name="name" key="label.textfield.name" />
    <s:submit key="button.submit" />
</s:form>

<s:a action="party">Party Modus!</s:a>
<img src="ressources/parrotwave1.gif">
<img src="ressources/parrotwave2.gif">
<img src="ressources/parrotwave3.gif">
<img src="ressources/parrotwave4.gif">
<img src="ressources/parrotwave5.gif">
<img src="ressources/parrotwave6.gif">
<img src="ressources/parrotwave7.gif">

</body>
</html>

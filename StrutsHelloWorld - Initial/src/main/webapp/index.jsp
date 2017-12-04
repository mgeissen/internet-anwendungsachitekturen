<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Struts Hello World</title>
</head>
<body>
<h1>Struts Hell World</h1>
<s:form action="sayhello">
    <p>Please enter your name</p>
    <s:textfield name="name" label="Name" />
    <s:submit value="Send" />
</s:form>

<s:a action="party">Party Modus!</s:a>
</body>
</html>

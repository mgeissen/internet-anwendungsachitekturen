<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <title><s:text name="header.application"/></title>
</head>
<body>
<h1><s:text name="header.application"/></h1>
<s:actionmessage/>
<s:actionerror/>
<tiles:insertAttribute name="content" />

</body>
</html>

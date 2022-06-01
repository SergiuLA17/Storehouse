<%--
  Created by IntelliJ IDEA.
  User: Segio
  Date: 30.05.2022
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/GetMeProduct" method="post">
    Name : <label>
    <input type="text" name="product">
</label>
    <input type="submit" value="Submit"> <input type="reset">
</form>
</body>
</html>

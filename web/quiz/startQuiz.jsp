<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Question" %><%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/12/2017
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ubiquitous</title>
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap.css" type="text/css" rel="stylesheet">

</head>
<body>

<header>
    <%@include file="../templates/header.jsp" %>

</header>

<div class="container">
    <div class="text-center">
        <a href="viewQuestion?page=viewQuestion" title="Start"> <img src="../images/start.png" border="0" height="200px" width="200px" title="Start Quiz"></a>
    </div>
</div>

</body>
</html>
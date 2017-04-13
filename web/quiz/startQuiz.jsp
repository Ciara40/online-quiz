<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Question" %><%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/12/2017
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Question question=(Question)request.getAttribute("question");
    if(question!=null) {
        int id = question.getId();
        int nextId = id + 1;
        request.setAttribute("nextId", nextId);
    }
%>
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

<div id="content">
    <c:choose>
        <c:when test="${question.id!=null}">
            <table>

                <tr>
                    <td>${question.id}</td>
                    <td colspan="2">${question.questionDetail}</td>
                <tr>
                    <td></td>
                    <td><input type="checkbox" value="${question.option1}">${question.option1}</td>
                    <td><input type="checkbox" value="${question.option2}">${question.option2}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" value="${question.option3}">${question.option3} </td>
                    <td><input type="checkbox" value="${question.option4}">${question.option4}</td>

                </tr>


                <tr>
                    <td colspan="3"><a href="startQuiz?page=startQuiz&id=${nextId}"> <img src="../images/next.png" height="50" width="200"></a> </td>
                </tr>
            </table>
        </c:when>
        <c:otherwise>
            <div id="over" style="position:absolute; width:100%; height:100%">
                <a href="#" title="Check Score"> <img src="../images/done.png"></a>
            </div>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/9/2017
  Time: 7:47 AM
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
    <div class="logo1">
        <a href="addQuestion?page=questionForm"><img src="../images/question.png" alt="Add question" border="0" height="80px" width="80px" title="Add question"></a>
    </div>

    <div class="alert-success">${msg}</div>
    <div class="table-title">
        <h2 style="color: deepskyblue">List of questions</h2>
    </div>
    <div class="table-responsive table-bordered ">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>Id</th>
                <th>Question</th>
                <th>Option1</th>
                <th>Option2</th>
                <th>Option3</th>
                <th>Option4</th>
                <th>Correct Answer</th>
                <th>Category</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>

            <c:forEach items="${questionList}" var="question">
                <tbody class="tbody-striped">
                <tr>
                    <td>${question.id}</td>
                    <td>${question.questionDetail}</td>
                    <td>${question.option1}</td>
                    <td>${question.option2}</td>
                    <td>${question.option3}</td>
                    <td>${question.option4}</td>
                    <td>${question.correctAns}</td>
                    <td>${question.category}</td>
                    <td><a href="editQuestion?page=editForm&id=${question.id}" class="btn btn-primary btn-sm"><span
                            class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="deleteQuestion?page=delete&id=${question.id}" class="btn btn-danger btn-sm"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
                </tbody>
            </c:forEach>

        </table>
    </div>

</div>
<%@include file="../templates/footer.jsp" %>

</body>
</html>
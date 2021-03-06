<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/16/2017
  Time: 11:10 AM
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

    <div class="table-title">
        <h2 style="color: deepskyblue">Final Result</h2>
    </div>
    <div class="table-responsive table-bordered ">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>S.N.</th>
                <th>Question</th>
                <th>Selected Answered</th>
                <th>Correct Answer</th>
                <th>Correctness</th>

            </tr>
            </thead>

            <c:forEach items="${answeredQuestions}" var="answeredQuestion" varStatus="loop">
                <tbody class="tbody-striped">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${answeredQuestion.questionDetail}</td>
                    <td>${answeredQuestion.selectedAns}</td>
                    <td>${answeredQuestion.correctAns}</td>

                    <c:choose>
                        <c:when test="${!answeredQuestion.correctness}">
                            <td class="alert-danger">Wrong</td>
                        </c:when>
                        <c:otherwise>
                            <td class="success">Correct</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
                </tbody>
            </c:forEach>

        </table>
    </div>

</div>

<footer>
    <%@include file="../templates/footer.jsp" %>
</footer>

</body>
</html>

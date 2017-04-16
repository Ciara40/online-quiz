<%@ page import="domain.Question" %><%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/15/2017
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ubiquitous</title>
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap.css" type="text/css" rel="stylesheet">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.js"></script>
    <script src="../js/custom.js"></script>

</head>
<body>

<header>
    <%@include file="../templates/header.jsp" %>

</header>

<div class="container">
    <c:choose>
        <c:when test="${question!= null}">
            <form method="post" action="nextQuestion">
                <input type="hidden" name="questionDetail" value="${question.questionDetail}">
                <input type="hidden" name="page" value="nextQuestion">
                <input id="correctAns" type="hidden" name="correctAns" value="${question.correctAns}">
                <p>${question.questionDetail}</p>
                <div class="radio">
                    <label>
                        <input type="radio" name ="choice" value="${question.option1}">
                            ${question.option1}
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name ="choice" value="${question.option2}">
                            ${question.option2}
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name ="choice" value="${question.option3}">
                            ${question.option3}
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name ="choice" value="${question.option4}">
                            ${question.option4}
                    </label>
                </div>
                <button type="submit"  class="btn btn-primary btn-lg" value="nextQuestion">Next Question</button>

            </form>
        </c:when>
        <c:otherwise>
            <h1 class="text-center">Thank you for taking the test.</h1>
            <div id="over" style="position:absolute; width:100%; height:100%">
                <a href="viewResult?page=viewResult" title="View Score">View Score</a>
            </div>
        </c:otherwise>
    </c:choose>
</div>


</body>
</html>

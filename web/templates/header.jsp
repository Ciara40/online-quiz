<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/11/2017
  Time: 8:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron text-center">
    <h1>UBIQUITOUS</h1>
    <h2>AVAILABLE ANYWHERE AND EVERYWHERE</h2>
</div>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">${sessionScope.user.name}</a>
        </div>

        <ul class="nav navbar-nav navbar-left">

            <li class="active"><a href="home?page=home">Home</a></li>

            <c:if test="${sessionScope.user.role == 'admin'}">
            <li><a href="userList?page=userList">User</a></li>
            <li><a href="questionList?page=questionList">Quiz</a></li>
            </c:if>
            <li><a href="startQuiz?page=startQuiz">Start Quiz</a> </li>
            <li><a href="viewResult?page=viewResult">View Scores</a> </li>
            
            <li><a href="#">Contact Us</a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="logout?page=logout"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
        </ul>
    </div>
</nav>
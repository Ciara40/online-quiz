<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/5/2017
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ubiquitous</title>
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap.css" type="text/css" rel="stylesheet">
</head>

<body>

<header>

    <div class="jumbotron text-center">
        <h1>UBIQUITOUS</h1>
        <h2>AVAILABLE ANYWHERE AND EVERYWHERE</h2>
    </div>

</header>
<div class="container">
    <div class="text-center" style="padding:50px 0">
        <div class="row">
            <div class="logo">Registration form</div>
            <div class="login-page">
                <div class="form">
                    <div>${msg}</div>
                    <form class="form-horizontal" action="register" method="post">
                        <input type="hidden" name="page" value="register">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="username-signup">Username:</label>
                            <div class="col-sm-9">
                                <input type="text" name="username" id="username-signup" tabindex="1" class="form-control" placeholder="Username" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="password-signup">Password:</label>
                            <div class="col-sm-9">
                                <input type="password" name="password" id="password-signup" tabindex="2" class="form-control" placeholder="Password" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="confirm-password">Re-Password:</label>
                            <div class="col-sm-9">
                                <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" required>
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label class="control-label col-sm-3" for="role-signup">Role:</label>
                            <div class="col-sm-9">
                                <input type="text" name="role" id="role-signup" tabindex="2" class="form-control" placeholder="Role" required>
                            </div>
                        </div>--%>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary btn-lg">Sign Up</button>
                            </div>
                        </div>
                        <div>
                            <p class="message">Already have an account? <a href="return?page=return">Login</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

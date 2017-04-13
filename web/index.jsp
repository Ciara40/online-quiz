<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 3/22/2017
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ubiquitous</title>
    <link href="css/style.css" rel="stylesheet">
    <link href="css/bootstrap.css" type="text/css" rel="stylesheet">
</head>

<body>

<header>

    <div class="jumbotron text-center">
        <h1>UBIQUITOUS</h1>
        <h2>AVAILABLE ANYWHERE AND EVERYWHERE</h2>
    </div>

</header>

<div class="container">
    <div class="text-center" style="padding:20px 0">
        <div class="row">
            <div class="logo">Please login to continue</div>
            <div class="login-page">
                <div class="form">
                    <div class="text-success success-message">${msg}</div>
                    <form class="form-horizontal" method="post" action="login">
                        <input type="hidden" name="page" value="login">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="username">Username:</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="username" placeholder="Username" name="username" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="pwd">Password:</label>
                            <div class="col-sm-9">
                                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                                <div class="checkbox">
                                    <label><input type="checkbox">Remember me</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
                                <button type="submit" onclick="getAlert()" class="btn btn-primary btn-lg btn-block" >Log In</button>
                            </div>
                        </div>
                        <div>
                            <p class="message">Not registered? <a href="register?page=signup">Create an account</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" language = "javascript">
    function getAlert() {
        var ea = document.getElementById("username").value;
        var pw = document.getElementById("pwd").value;
        console.log(ea);
        console.log(pw);
        if (ea == "" || pw =="") {
            alert("Invalid entry");
        }
    }
</script>
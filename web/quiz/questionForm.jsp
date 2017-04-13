<%--
  Created by IntelliJ IDEA.
  User: usha
  Date: 4/9/2017
  Time: 10:24 PM
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
            <div class="logo">New Question Form</div>

            <%--<div class="login-page">--%>

                <div class="form">
                    <div class="alert-danger">${msg}</div>
                    <form class="form-horizontal" action="addQuestion" method="post">
                        <input type="hidden" name="page" value="addQuestion">
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="question">Question:</label>
                            <div class="col-sm-9">
                                <input type="text" name="question" id="question" tabindex="1" class="form-control" placeholder="question" value="" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="option1">option 1:</label>
                            <div class="col-sm-9">
                                <input type="text" name="option1" id="option1" tabindex="2" class="form-control" placeholder="option1" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="option2">option 2:</label>
                            <div class="col-sm-9">
                                <input type="text" name="option2" id="option2" tabindex="2" class="form-control" placeholder="option2" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="option3">option 3:</label>
                            <div class="col-sm-9">
                                <input type="text" name="option3" id="option3" tabindex="2" class="form-control" placeholder="option3" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="option4">option 4:</label>
                            <div class="col-sm-9">
                                <input type="text" name="option4" id="option4" tabindex="2" class="form-control" placeholder="option4" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="correctAns">Correct Answer:</label>
                            <div class="col-sm-9">
                                <input type="text" name="correctAnswer" id="correctAns" tabindex="2" class="form-control" placeholder="correct answer" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-3" for="category">Category:</label>
                            <div class="col-sm-9">
                                <input type="text" name="category" id="category" tabindex="2" class="form-control" placeholder="category" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6 col-sm-offset-3">
                                <button type="submit" class="btn btn-primary btn-lg">Add Question</button>
                            </div>
                        </div>
                        <div>
                            <p class="message"><a href="cancelQuestion?page=cancel">Cancel</a></p>
                        </div>
                    </form>
                </div>
            <%--</div>--%>
        </div>
    </div>
</div>
</body>
</html>

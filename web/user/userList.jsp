<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Ubiquitous</title>
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/bootstrap.css" type="text/css" rel="stylesheet">

</head>
<body>
<header>
    <%@include file="../templates/header.jsp"%>
</header>


<div class="container">
    <div class="logo1">
        <a href="userForm?page=userForm"><img src="../images/adduser.png" alt="Add user" border="0" height="50px" width="50px" title="Add User"></a>
    </div>

    <div class="alert-success">${msg}</div>
    <div class="table-title">
        <h2 style="color: deepskyblue">List of User</h2>
    </div>
    <div class="table-responsive table-bordered ">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>User Name</th>
                <th>Password</th>
                <th>Role</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${userList}" var="user">
                <tbody class="tbody-striped">
                <tr>
                    <td>${user.name}</td>
                    <td>${user.password}</td>
                    <td>${user.role}</td>
                    <td><a href="edit?page=editForm&id=${user.id}" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-edit"></span></a></td>
                    <td><a href="delete?page=delete&id=${user.id}" class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
                </tbody>
            </c:forEach>

        </table>
    </div>

</div>

<footer class = "container">
    <div class="footer text-center">
        &copy Usha Adhkari
    </div>
</footer>

</body>
</html>
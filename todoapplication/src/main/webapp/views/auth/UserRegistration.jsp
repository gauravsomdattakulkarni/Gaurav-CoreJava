<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.kulkarni.gaurav.projects.todoapp.todoapplication.model.User" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>To Do Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="stylesheet" type="text/css" href="style1.css">
    <style>
        h2 {
            font-size: 16px;
            margin-bottom: 5px;
        }
        p {
            font-size: 12px;
            margin: 0;
        }
        .bg-clr {
            background-color: #f1faee;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-clr">
        <div class="container">
            <a class="navbar-brand fs-1 fw-medium" href="#">To Do Application</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="user_login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="register_user">Register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12 mb-5">
                <div class="card bg-warning">
                    <div class="card-body text-center">
                        <h5 class="card-title">Registration</h5>

                    </div>
                </div>
            </div>

            <div>
                <c:if test="${not empty message}">
                        <div class="my-2 alert alert-success flash-message">
                            ${message}
                        </div>
                 </c:if>

                 <c:if test="${not empty error_message}">
                     <div class="my-2 alert alert-danger flash-message">
                         ${error_message}
                     </div>
                 </c:if>
            </div>

            <form action="register_user_success" method="post">
                <div class="row">
                    <div class="col-md-6 my-3">
                        <label for="userName">User Name:</label>
                        <input class="form-control" type="text" id="userName" name="userName" required>
                    </div>
                    <div class="col-md-6 my-3">
                        <label for="mobileNo">Mobile No:</label>
                        <input class="form-control" type="text" id="mobileNo" name="mobileNo" required>
                    </div>
                    <div class="col-md-6 my-3">
                        <label for="emailId">Email ID:</label>
                        <input class="form-control" type="email" id="emailId" name="emailId" required>
                    </div>
                    <div class="col-md-6 my-3">
                        <button class="btn btn-primary btn-lg" type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#mobileNo').on('input', function() {
                this.value = this.value.replace(/[^0-9]/g, '').slice(0, 10);
            });
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

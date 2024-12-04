<%@page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="jumbotron text-center">
        <h1 class="display-4">Number Adding Form</h1>
        <p class="lead">Enter two numbers and submit to get the sum.</p>
    </div>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <form action="add" method="POST">
                            <div class="form-group">
                                <label for="num1">Enter Number 1</label>
                                <input type="number" class="form-control" id="num1" name="num1" min="0" required>
                            </div>
                            <div class="form-group">
                                <label for="num2">Enter Number 2</label>
                                <input type="number" class="form-control" id="num2" name="num2" min="0" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>

                        <form action="addAlien" class="my-3" method="POST">
                           <div class="form-group">
                              <label for="num1">Enter AID</label>
                              <input type="text" class="form-control" id="aid" name="aid"  required>
                           </div>
                           <div class="form-group">
                              <label for="num2">Enter name</label>
                              <input type="text" class="form-control" id="aname" name="aname" min="0" required>
                           </div>
                           <button type="submit" class="btn btn-primary">Add Alien</button>
                        </form>


                    </div>
                </div>
            </div>

        </div>

        <table class="table tabled-bordered table-stripped">
            <thead>
                <tr>
                    <th scope="col">AID</th>
                    <th scope="col">Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="alien" items="${aliens}">
                    <tr>
                        <td>${alien.aid}</td>
                        <td>${alien.aname}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<%@page language="java" %>

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
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
    <title>Login</title>
</head>
<body>
    <div class="container my-5">
        <form action="login" method="post" autocomplete="off">
            <div class="container my-5">
                <h2>Log in</h2>
                <div class="form-group mb-4">
                    <label for="usernameInput">Username</label>
                    <input type="text" name="username" class="form-control" id="usernameInput" placeholder="Enter your username">
                </div>
                <div class="form-group mb-4">
                    <label for="passwordInput">Password</label>
                    <input type="password" name="password" class="form-control" id="passwordInput" placeholder="Enter your password">
                </div>
                <%
                    if (request.getAttribute("error") != null) {
                        out.println("<div class='alert alert-danger' role='alert'>" + request.getAttribute("error") + "</div>");
                    }
                %>
                <button type="submit" class="btn btn-primary">Log in</button>
            </div>
        </form>
    </div>
</body>
</html>
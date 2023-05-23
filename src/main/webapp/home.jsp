<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect("/quiz/login");
    }
%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Home</title>
    </head>
    <body>
        <form action="quiz" method="post" autocomplete="off">
            <div class="container my-5">
                <h2>Quiz configuration</h2>
                <h3>Welcome <%= session.getAttribute("username") %> - configure your quiz</h3>
                <div class="form-group mb-4">
                    <label for="questionsTotal">Number of Questions</label>
                    <input type="number" class="form-control" id="questionsTotal" name="questionsTotal" placeholder="#" required min="1" value="1">
                </div>
                <div class="form-group mb-4">
                    <label for="questionsPerPage">Questions per Page</label>
                    <input type="number" class="form-control" id="questionsPerPage" name="questionsPerPage" placeholder="#" required min="1" value="1">
                </div>
                <%
                    if (request.getAttribute("error") != null) {
                        out.println("<div class='alert alert-danger' role='alert'>" + request.getAttribute("error") + "</div>");
                    }
                %>
                <button type="submit" class="btn btn-primary">Start quiz</button>
            </div>
        </form>
        <div class="container my-1">
            <form action="logout" method="post">
                <button type="submit" class="btn btn-primary">Log out</button>
            </form>
        </div>
    </body>
</html>

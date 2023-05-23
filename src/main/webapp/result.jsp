<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect("/quiz/login");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>Quiz</title>
    </head>
    <body>
        <div class="container my-5">
            <h2>Results</h2>
            <p>Score: <%= session.getAttribute("score") %></p>
            <p>Wrong answers: <%= request.getAttribute("wrong") %></p>
            <p>Highscore: <%= session.getAttribute("highscore") %></p>
            <a class="btn btn-primary" href="/quiz" role="button">Home</a>
        </div>
    </body>
</html>

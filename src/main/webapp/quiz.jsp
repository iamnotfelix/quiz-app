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

        <h1>Quiz</h1>
        <p>Number of Questions: <%= session.getAttribute("questionsTotal") %></p>
        <p>Questions per Page: <%= session.getAttribute("questionsPerPage") %></p>
        <p>Total Pages: <%= session.getAttribute("totalPages") %></p>

        <%@ page import="java.util.List" %>
        <%@ page import="models.Question" %>
        <%@ page import="models.Answer" %>
        <%
            List<Question> questions = (List<Question>) request.getAttribute("questions");
            for (Question question : questions) {
                out.println("<p>" + Integer.toString(question.GetId()) + ". " + question.GetText() + "</p>");
                for (Answer answer : question.GetAnswers()) {
                    out.println("<p>" + answer.GetText() + "</p>");
                }
            }
        %>

        <a class="btn btn-primary" href="quiz" role="button">Next</a>
        
    </body>
</html>

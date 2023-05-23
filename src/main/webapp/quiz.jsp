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
            <h2>Quiz</h2>
            <p>Number of Questions: <%= session.getAttribute("questionsTotal") %></p>
            <p>Questions per Page: <%= session.getAttribute("questionsPerPage") %></p>
            <p>Total Pages: <%= session.getAttribute("totalPages") %></p>

            <form action='answer' method='post'>
                <%@ page import="java.util.List" %>
                <%@ page import="models.Question" %>
                <%@ page import="models.Answer" %>
                <%
                    List<Question> questions = (List<Question>) request.getAttribute("questions");
                    int i = 1;
                    for (Question question : questions) {
                        out.println("<div class='container mb-2'>");
                        out.println("<p>" + Integer.toString(question.GetId()) + ". " + question.GetText() + "</p>");
                        for (Answer answer : question.GetAnswers()) {
                            out.println(
                                "<div class='form-check'>" + 
                                    "<input class='form-check-input' type='radio' name='question" + Integer.toString(i) + "' id='question" + Integer.toString(i) + "' value='" + Boolean.toString(answer.GetIsCorrect()) + "'>" +
                                    "<label class='form-check-label' for='question" + Integer.toString(i) + "'>" +
                                    answer.GetText() +
                                    "</label>" +
                                "</div>"
                            );
                        }
                        ++i;
                        out.println("</div>");
                    }
                %>
                <button type="submit" class="btn btn-primary">Next</button>
                <!-- <a class="btn btn-primary" href="quiz" role="button">Next</a> -->
            </form>
        </div>
    </body>
</html>

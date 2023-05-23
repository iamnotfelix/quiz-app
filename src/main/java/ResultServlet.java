import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Question;


@WebServlet("/quiz")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int questionsTotal = (int) session.getAttribute("questionsTotal");
        int questionsPerPage = (int) session.getAttribute("questionsPerPage");
        int totalPages = (int) session.getAttribute("totalPages");
        int current = (int) session.getAttribute("current");
        int score = (int) session.getAttribute("score");

        for (int i = 1; i <= questionsPerPage; ++i)
        {
            boolean value = Boolean.parseBoolean(request.getParameter("question" + Integer.toString(i)));
            if (value) { ++score; }
        }

        session.setAttribute("score", score);

        int take = questionsPerPage;
        if (current >= totalPages) 
        {
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        if (current + 1 == totalPages)
        {
            take = questionsTotal - current * questionsPerPage;
        }

        session.setAttribute("current", current + 1);
        session.setAttribute("questionsPerPage", take);

        IRepository repository = new Repository();
        List<Question> questions = repository.GetQuestions(current + 1, questionsPerPage, take);

        request.setAttribute("questions", questions);
        
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}

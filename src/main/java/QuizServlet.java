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
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // private IRepository repository = null;

    // @Override
    // public void init() throws ServletException {
    //     super.init();
    //     this.repository = new Repository();
    // }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionsTotal = Integer.parseInt(request.getParameter("questionsTotal"));
        int questionsPerPage = Integer.parseInt(request.getParameter("questionsPerPage"));
        int totalPages = (int) Math.ceil((double) questionsTotal / questionsPerPage);
        int current = 1;

        HttpSession session = request.getSession();
        session.setAttribute("questionsTotal", questionsTotal);
        session.setAttribute("questionsPerPage", questionsPerPage);
        session.setAttribute("totalPages", totalPages);
        session.setAttribute("current", 1);
        
        request.setAttribute("current", current);

        IRepository repository = new Repository();
        List<Question> questions = repository.GetQuestions(current, questionsPerPage);

        request.setAttribute("questions", questions);
        
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int questionsTotal = (int) session.getAttribute("questionsTotal");
        int questionsPerPage = (int) session.getAttribute("questionsPerPage");
        int totalPages = (int) session.getAttribute("totalPages");
        int current = (int) session.getAttribute("current");
        if (current == totalPages) 
        {
            // TODO: redirect to result page
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        if (current + 1 == totalPages)
        {
            questionsPerPage = questionsTotal - current * questionsPerPage;
        }

        session.setAttribute("current", current + 1);

        IRepository repository = new Repository();
        List<Question> questions = repository.GetQuestions(current + 1, questionsPerPage);

        request.setAttribute("questions", questions);
        
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
}

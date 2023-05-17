import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionsTotal = Integer.parseInt(request.getParameter("questionsTotal"));
        int questionsPerPage = Integer.parseInt(request.getParameter("questionsPerPage"));
        
        int totalPages = (int) Math.ceil((double) questionsTotal / questionsPerPage);
        
        request.setAttribute("questionsTotal", questionsTotal);
        request.setAttribute("questionsPerPage", questionsPerPage);
        request.setAttribute("totalPages", totalPages);
        
        request.getRequestDispatcher("quiz.jsp").forward(request, response);
    }
    
    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     // Forward the request to the JSP file
    //     request.getRequestDispatcher("quiz.jsp").forward(request, response);
    // }
}

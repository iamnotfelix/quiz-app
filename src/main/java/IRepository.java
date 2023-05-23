import java.util.List;

import models.Answer;
import models.Question;
import models.User;

public interface IRepository {
    List<Question> GetQuestions(int current, int questionsPerPage, int take);
    List<Answer> GetAnswers(int questionId);
    User Login(String username, String password);
}

import java.util.List;

import models.Answer;
import models.Question;

public interface IRepository {
    List<Question> GetQuestions(int current, int questionsPerPage);
    List<Answer> GetAnswers(int questionId);
}

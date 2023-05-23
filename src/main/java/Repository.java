import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Answer;
import models.Question;
import models.User;

public class Repository implements IRepository{

    // private String connectionString = "Server=localhost;Database=quiz;Uid=root;Pwd=rootroot;";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/quiz";
    private String username = "root";
    private String password = "rootroot";

    @Override
    public List<Question> GetQuestions(int current, int questionsPerPage, int take) {
        int skip = (current - 1) * questionsPerPage;
        
        String sql = "SELECT * FROM questions ORDER BY id LIMIT ? OFFSET ?";
        List<Question> questions = new ArrayList<Question>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, take);
            statement.setInt(2, skip);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                List<Answer> answers = this.GetAnswers(id);
                Question question = new Question(id, text, answers);
                questions.add(question);
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    @Override
    public List<Answer> GetAnswers(int questionId) {
        String sql = "SELECT * FROM answers WHERE questionId = ?";
        List<Answer> answers = new ArrayList<Answer>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                boolean isCorrect = resultSet.getBoolean("isCorrect");
                Answer answer = new Answer(id, text, isCorrect, questionId);
                answers.add(answer);
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answers;
    }

    @Override
    public User Login(String name, String pass) {
        String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String pwd = resultSet.getString("password");
                int highscore = resultSet.getInt("highscore");
                if (!pwd.equals(pass))
                {
                    return user;
                }
                user = new User(id, name, pass, highscore);
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
}

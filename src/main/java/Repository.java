import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Question;

// import models.Question;

public class Repository implements IRepository{

    // private String connectionString = "Server=localhost;Database=quiz;Uid=root;Pwd=rootroot;";
    private String jdbcUrl = "jdbc:mysql://localhost:3306/quiz";
    private String username = "root";
    private String password = "rootroot";

    @Override
    public List<Question> GetQuestions() {
        String sql = "SELECT * FROM questions";
        List<Question> questions = new ArrayList<Question>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                Question question = new Question(id, text);
                questions.add(question);
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }
    
}

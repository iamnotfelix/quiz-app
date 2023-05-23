package models;

import java.util.List;

public class Question {
    private int id;
    private String text;
    private List<Answer> answers;

    public Question(int id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public int GetId()
    {
        return this.id;
    }

    public String GetText()
    {
        return this.text;
    }

    public List<Answer> GetAnswers()
    {
        return this.answers;
    }
}

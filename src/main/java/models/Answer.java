package models;

public class Answer {
    private int id;
    private String text;
    private boolean isCorrect;
    private int questionId;
    
    public Answer(int id, String text, boolean isCorrect, int questionId)
    {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    public int GetId()
    {
        return this.id;
    }

    public String GetText()
    {
        return this.text;
    }  

    public boolean GetIsCorrect()
    {
        return this.isCorrect;
    }

    public int GetQuestionid()
    {
        return this.questionId;
    }
}

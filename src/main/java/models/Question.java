package models;

public class Question {
    private int id;
    private String text;

    public Question(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int GetId()
    {
        return this.id;
    }

    public String GetText()
    {
        return this.text;
    }
}

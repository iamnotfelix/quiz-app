package models;

public class User {
    private int id;
    private String username;
    private String password;
    private int highscore;

    public User(int id, String username, String password, int highscore)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.highscore = highscore;
    }

    public int GetId()
    {
        return this.id;
    }

    public String GetUsername() 
    {
        return this.username;
    }

    public String GetPassword()
    {
        return this.password;
    }

    public int GetHighscore()
    {
        return this.highscore;
    }
}

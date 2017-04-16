package domain;


import java.util.Date;

/**
 * Created by usha on 4/16/2017.
 */
public class Result {
    private int id;
    private int userId;
    private int score;
    private Date datePlayed;

    public Result(int userId, int score, Date datePlayed) {
        this.userId = userId;
        this.score = score;
        this.datePlayed = datePlayed;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public Date getDatePlayed() {
        return datePlayed;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", userId=" + userId +
                ", score=" + score +
                ", datePlayed=" + datePlayed +
                '}';
    }
}

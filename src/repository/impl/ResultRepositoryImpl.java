package repository.impl;

import domain.Result;
import repository.ResultRepository;
import utils.DatabaseConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
public class ResultRepositoryImpl implements ResultRepository{
    @Override
    public void saveResult(Result result) {
        String query = "insert into result (user_id, date_played, score) values (?, ?, ?)";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setInt(1, result.getUserId());
            pstm.setDate(2, new Date(result.getDatePlayed().getTime()));
            pstm.setInt(3, result.getScore());
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Result> findAllByUserId(int userId) {
        List<Result> results = new ArrayList<>();
        String query = "select * from result where user_id = ?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);

        try {
            pstm.setInt(1, userId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                int uId = rs.getInt("user_id");
                int score = rs.getInt("score");
                java.util.Date datePlayed = rs.getDate("date_played");
                Result result = new Result(uId, score, datePlayed);
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}

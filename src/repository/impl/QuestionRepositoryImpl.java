package repository.impl;

import domain.Question;
import repository.QuestionRepository;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public class QuestionRepositoryImpl implements QuestionRepository {
    @Override
    public List<Question> findAll() {
        List<Question> questionList = new ArrayList<Question>();
        String query = "select * from question";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);

        try {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestionDetail(rs.getString("question_detail"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAns(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    @Override
    public Integer save(Question question) {
        String saveQuery = "Insert into question(question_detail, option1, option2, option3, option4, correct_answer, category) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(saveQuery);

        try {
            pstm.setString(1, question.getQuestionDetail());
            pstm.setString(2, question.getOption1());
            pstm.setString(3, question.getOption2());
            pstm.setString(4, question.getOption3());
            pstm.setString(5, question.getOption4());
            pstm.setString(6, question.getCorrectAns());
            pstm.setString(7, question.getCategory());
            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void delete(int id) {
        String query = "delete from question where id = ?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int update(Question question) {
        String query = "update question set question_detail = ?, option1 = ?, option2 = ?, option3 = ?, option4 = ?, correct_answer = ?, category = ? where id = ?";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        int updatedRowNum = 0;
        try {
            pstm.setString(1, question.getQuestionDetail());
            pstm.setString(2, question.getOption1());
            pstm.setString(3, question.getOption2());
            pstm.setString(4, question.getOption3());
            pstm.setString(5, question.getOption4());
            pstm.setString(6, question.getCorrectAns());
            pstm.setString(7, question.getCategory());
            pstm.setInt(8, question.getId());
            updatedRowNum = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRowNum;
    }

    @Override
    public Question findQuestionById(int id) {
        Question question = null;

        String query = "select * from question where id not in(0,1) limit 1";
        String values = "";
        /*for (int id :ids){
            values+= id+",";
        }*/
        query = query + values;
        /*int ind = query.lastIndexOf(",");*/
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestionDetail(rs.getString("question_detail"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectAns(rs.getString("correct_answer"));
                question.setCategory(rs.getString("category"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    @Override
    public void saveResult(int user_id, int question_id, int marks) {
        String query = "insert (user_id, question_id, marks)";

    }

    @Override
    public int[] getPlayedQuestion() {
        String query = "select question_id from result";
        PreparedStatement pstm = DatabaseConnection.getPreparedStatement(query);
        try {
            ResultSet rs = pstm.executeQuery();
            /*while (rs.next()){
                
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

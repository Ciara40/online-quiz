package repository;

import domain.Question;

import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public interface QuestionRepository {
    List<Question> findAll();
    Integer save(Question question);
    void delete(int id);
    int update(Question question);
    Question findQuestionById(int id);
    void saveResult(int user_id, int question_id, int marks);
    int [] getPlayedQuestion();
}

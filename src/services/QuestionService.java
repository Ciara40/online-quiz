package services;

import domain.Question;

import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public interface QuestionService {
    List<Question> getQuestionList();
    Integer save(Question question);
    void deleteQuiz(int id);
    int update(Question question);
    Question getQuizById(int id);
}

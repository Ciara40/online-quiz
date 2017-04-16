package services;

import domain.Question;
import domain.Result;

import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public interface QuestionService {
    List<Question> getQuestionList();
    Integer save(Question question);
    void deleteQuiz(int id);
    Question edit(int id);
    int update(Question question);
    Question getQuizById(List<Integer> ids);

    List<Integer> getPlayedQuestion();
}

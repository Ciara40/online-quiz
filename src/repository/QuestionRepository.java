package repository;

import domain.Question;
import domain.Result;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public interface QuestionRepository {
    List<Question> findAll();
    Integer save(Question question);
    void delete(int id);
    Question edit(int id);
    int update(Question question);
    Question findQuestionById(List<Integer> ids);

    List<Integer> findPlayedQuestion();
}

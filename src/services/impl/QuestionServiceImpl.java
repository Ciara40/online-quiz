package services.impl;

import domain.Question;
import domain.Result;
import repository.QuestionRepository;
import repository.impl.QuestionRepositoryImpl;
import services.QuestionService;

import java.util.List;

/**
 * Created by usha on 4/8/2017.
 */
public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    public QuestionServiceImpl(){
        this.questionRepository = new QuestionRepositoryImpl();
    }
    @Override
    public List<Question> getQuestionList() {
        return this.questionRepository.findAll();
    }

    @Override
    public Integer save(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public void deleteQuiz(int id) {
        this.questionRepository.delete(id);
    }

    @Override
    public Question edit(int id) {
        return this.questionRepository.edit(id);
    }

    @Override
    public int update(Question question) {
        return this.questionRepository.update(question);
    }

    @Override
    public Question getQuizById(List<Integer> ids) {
        return this.questionRepository.findQuestionById(ids);
    }



    @Override
    public List<Integer> getPlayedQuestion() {
        return this.questionRepository.findPlayedQuestion();
    }
}

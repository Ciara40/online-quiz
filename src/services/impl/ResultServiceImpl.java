package services.impl;

import domain.Result;
import repository.ResultRepository;
import repository.impl.ResultRepositoryImpl;
import services.ResultService;

import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
public class ResultServiceImpl implements ResultService {
    private ResultRepository resultRepository;
    public ResultServiceImpl(){
        this.resultRepository = new ResultRepositoryImpl();
    }
    @Override
    public void saveResult(Result result) {
        this.resultRepository.saveResult(result);
    }

    @Override
    public List<Result> getAllByUserId(int userId) {
        return this.resultRepository.findAllByUserId(userId);
    }
}

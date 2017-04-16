package repository;

import domain.Result;

import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
public interface ResultRepository {
    void saveResult(Result result);
    List<Result> findAllByUserId(int userId);
}

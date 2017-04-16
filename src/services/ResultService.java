package services;

import domain.Result;

import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
public interface ResultService  {
    void saveResult(Result result);
    List<Result> getAllByUserId(int userId);
}

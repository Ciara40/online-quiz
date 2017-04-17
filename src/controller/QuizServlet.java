package controller;

import domain.AnsweredQuestion;
import domain.Question;
import domain.Result;
import domain.User;
import services.QuestionService;
import services.ResultService;
import services.impl.QuestionServiceImpl;
import services.impl.ResultServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    private QuestionService questionService;
    private ResultService resultService;
    public QuizServlet() {
        this.questionService = new QuestionServiceImpl();
        this.resultService = new ResultServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        HttpSession session = request.getSession(false);
        RequestDispatcher rd = null;

        if (session == null || session.getAttribute("user") == null) {
            rd = request.getRequestDispatcher("index.jsp");
        }

        else if (page.equalsIgnoreCase("startQuiz")){
            rd = request.getRequestDispatcher("quiz/startQuiz.jsp");
        }

        else if (page.equalsIgnoreCase("viewQuestion")){
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(0);

            Question question = this.questionService.getQuizById(ids);

            ids.add(question.getId());
            session = request.getSession(false);
            session.setAttribute("questionsPlayed", ids);
            session.setAttribute("score", 0);


            List<AnsweredQuestion> answeredQuestions = new ArrayList<>();
            session.setAttribute("answeredQuestions", answeredQuestions);

            request.setAttribute("question", question);
            rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
        }

        else if(page.equalsIgnoreCase("nextQuestion")) {

            AnsweredQuestion answeredQuestion = getRequestAnsweredQuestion(request);

            List <AnsweredQuestion> answeredQuestions = (List<AnsweredQuestion>) session.getAttribute("answeredQuestions");
            answeredQuestions.add(answeredQuestion);
            session.setAttribute("answeredQuestions", answeredQuestions);

            List<Integer> ids = (List<Integer>) session.getAttribute("questionsPlayed");
            Question question = this.questionService.getQuizById(ids);
            if (question!= null){
                ids.add(question.getId());
                session.setAttribute("questionsPlayed", ids);
                request.setAttribute("question", question);
                rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
            }

            else if (question == null){
                //save result
                int userId = ((User)session.getAttribute("user")).getId();
                Date datePlayed = new Date();
                int finalScore = (Integer)session.getAttribute("score");
                Result result = new Result(userId, finalScore, datePlayed);
                this.resultService.saveResult(result);

                //show current score
                request.setAttribute("answeredQuestions", answeredQuestions);
                rd = request.getRequestDispatcher("result/displayResult.jsp");
            }

        }
        rd.forward(request,response);
    }

    private AnsweredQuestion getRequestAnsweredQuestion(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String clicked = request.getParameter("choice");
        String correctAns = request.getParameter("correctAns");
        String questionDetail = request.getParameter("questionDetail");
        Boolean correctness = clicked.equals(correctAns)? true: false;
        AnsweredQuestion answeredQuestion = new AnsweredQuestion(questionDetail, correctAns, clicked, correctness);

        /*List <AnsweredQuestion> answeredQuestions = (List<AnsweredQuestion>) session.getAttribute("answeredQuestions");
        answeredQuestions.add(answeredQuestion);
        session.setAttribute("answeredQuestions", answeredQuestions);*/

        int currentScore = clicked.equals(correctAns)? 5: 0; // (exp)? value1: value2;
        Integer score = (Integer)session.getAttribute("score");
        session.setAttribute("score", currentScore + score);
        return answeredQuestion;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

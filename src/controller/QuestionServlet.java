package controller;

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
 * Created by usha on 3/23/2017.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {

    private QuestionService questionService;
    private ResultService resultService;
    public QuestionServlet() {
        this.questionService = new QuestionServiceImpl();
        this.resultService = new ResultServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");

        RequestDispatcher rd = null;

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            rd = request.getRequestDispatcher("index.jsp");
        }

        else if (page.equalsIgnoreCase("questionList")) {

            System.out.println("After if block...");
            List<Question> questionList = this.questionService.getQuestionList();
            request.setAttribute("questionList", questionList);
            rd = request.getRequestDispatcher("quiz/questionList.jsp");
        }

        else if (page.equalsIgnoreCase("addQuestion")) {
            Question question = getRequestQuiz(request);
            int savedRowIndex = this.questionService.save(question);
            if(savedRowIndex <= 0) {
                request.setAttribute("msg", "Saving failed!!!");
                rd = request.getRequestDispatcher("quiz/questionForm.jsp");
            } else {
                List<Question> questionList = this.questionService.getQuestionList();
                request.setAttribute("questionList", questionList);
                request.setAttribute("msg", "Question Added ! ");
                rd = request.getRequestDispatcher("quiz/questionList.jsp");
            }
        }

        else if (page.equalsIgnoreCase("questionForm")) {
            rd = request.getRequestDispatcher("quiz/questionForm.jsp");
        }

        else if (page.equalsIgnoreCase("editForm")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Question question = this.questionService.edit(id);
            request.setAttribute("question", question);
            rd = request.getRequestDispatcher("quiz/updateQuestion.jsp");
        }

        else if (page.equalsIgnoreCase("updateQuestion")) {
            Question question = getRequestQuiz(request);

            int updateRowId = this.questionService.update(question);

            if (updateRowId > 0) {
                request.setAttribute("msg", "Question Successfully updated..");
                List<Question> questionList = this.questionService.getQuestionList();
                request.setAttribute("questionList", questionList);
                rd = request.getRequestDispatcher("quiz/questionList.jsp");
            } else {
                request.setAttribute("msg", "Question Update Failed!!!");
                request.setAttribute("question", question);
                rd = request.getRequestDispatcher("quiz/updateQuestion.jsp");
            }
        }

        else if (page.equalsIgnoreCase("cancel")){
            List<Question> questionList = this.questionService.getQuestionList();
            request.setAttribute("questionList", questionList);
            rd = request.getRequestDispatcher("quiz/questionList.jsp");
        }

        else if (page.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            this.questionService.deleteQuiz(id);
            request.setAttribute("msg", "Question Successfully deleted..");
            List<Question> questionList = this.questionService.getQuestionList();
            request.setAttribute("questionList", questionList);
            rd = request.getRequestDispatcher("quiz/questionList.jsp");
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

            request.setAttribute("question", question);
            rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
        }

        else if(page.equalsIgnoreCase("nextQuestion")) {
//            int questionId = Integer.parseInt(request.getParameter("id"));
            String clicked = request.getParameter("choice");
            String correctAns = request.getParameter("correctAns");
            int currentScore = clicked.equals(correctAns)? 5: 0; // (exp)? value1: value2;
            session = request.getSession(false);
            Integer score = (Integer)session.getAttribute("score");
            session.setAttribute("score", currentScore + score);


//            List<Integer> ids = this.questionService.getPlayedQuestion();
            List<Integer> ids = (List<Integer>) session.getAttribute("questionsPlayed");
            Question question = this.questionService.getQuizById(ids);
            if (question!= null){
                ids.add(question.getId());
                session.setAttribute("questionsPlayed", ids);
            }

            else if (question == null){
                //save result
                int userId = ((User)session.getAttribute("user")).getId();
                Date datePlayed = new Date();
                int finalScore = (Integer)session.getAttribute("score");
                Result result = new Result(userId, finalScore, datePlayed);
                this.resultService.saveResult(result);
            }
            request.setAttribute("question", question);
            rd = request.getRequestDispatcher("quiz/playQuiz.jsp");
        }

        rd.forward(request, response);

    }
    private Question getRequestQuiz(HttpServletRequest request) {
        Question question = new Question();

        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
            int id = Integer.parseInt(request.getParameter("id"));
            question.setId(id);
        }

        String questionDetail= request.getParameter("question");
        question.setQuestionDetail(questionDetail);
        question.setOption1(request.getParameter("option1"));
        question.setOption2(request.getParameter("option2"));
        question.setOption3(request.getParameter("option3"));
        question.setOption4(request.getParameter("option4"));
        question.setCorrectAns(request.getParameter("correctAnswer"));
        question.setCategory(request.getParameter("category"));

        return question;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

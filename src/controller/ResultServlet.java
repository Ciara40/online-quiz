package controller;

import domain.Result;
import domain.User;
import services.ResultService;
import services.impl.ResultServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by usha on 4/16/2017.
 */
@WebServlet(name = "ResultServlet")
public class ResultServlet extends HttpServlet {
    private ResultService resultService;
    public ResultServlet(){
        this.resultService = new ResultServiceImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);
        int userId = ((User)session.getAttribute("user")).getId();

        if ("viewResult".equalsIgnoreCase(page)){

            List<Result> results = this.resultService.getAllByUserId(userId);

            request.setAttribute("results", results);
            rd = request.getRequestDispatcher("result/displayResult.jsp");
        }
        rd.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

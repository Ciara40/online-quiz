package controller;

import domain.User;
import services.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet class to handle all request for user.
 *
 * Created by usha on 3/23/2017.
 */
public class UserServlet extends javax.servlet.http.HttpServlet {
    private UserServiceImpl userService;

    public UserServlet() {
        this.userService = new UserServiceImpl();
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String page = request.getParameter("page");

        RequestDispatcher rd = null;
        HttpSession session = request.getSession(false);

        if (page.equalsIgnoreCase("login")) {

            String name = request.getParameter("username");
            String password = request.getParameter("password");

            User user = this.userService.getUser(name, password);
            if (user == null) {
                request.setAttribute("msg", "Invalid User Or Password!!");
                rd = request.getRequestDispatcher("index.jsp");
            } else {
                request.setAttribute("msg", "Login Successful!!");
                session = request.getSession(false); //puranai session aaucha
                session.setAttribute("user", user);
                rd = request.getRequestDispatcher("user/homepage.jsp");
            }
        }
        else if (session == null || session.getAttribute("user") == null) {
            request.setAttribute("msg", "Session has expired..Please login to continue!!");
            rd = request.getRequestDispatcher("index.jsp");
        }
        else if (page.equalsIgnoreCase("signup")) {
            rd = request.getRequestDispatcher("user/signup.jsp");
        }

        else if (page.equalsIgnoreCase("logout")) {
            request.setAttribute("msg", "Logout Successful!!");
            session = request.getSession(false); // mathi jun name login ma use bhako cha tei name tanera leraucha
            session.removeAttribute("user");
            session.invalidate(); //clearing the session
            rd = request.getRequestDispatcher("index.jsp");//phone rec
        }

        else if (page.equalsIgnoreCase("register")) {
            User newUser = getRequestUser(request);
            newUser.setRole("ROLE_USER");
            int index = this.userService.save(newUser);

            if (index > 0) {
                request.setAttribute("msg", "Signup Successful!!");
                rd = request.getRequestDispatcher("index.jsp");
            } else {
                request.setAttribute("msg", "User already exists.");
                rd = request.getRequestDispatcher("user/signup.jsp");
            }
        }

        else if (page.equalsIgnoreCase("home")) {
            rd = request.getRequestDispatcher("user/homepage.jsp");
        }

        else if (page.equalsIgnoreCase("userList")) {
            List<User> userList = new UserServiceImpl().getUserList();
            request.setAttribute("userList", userList);
            // get all user from database
            // set userlist to response
            // forward request to user list page
            rd = request.getRequestDispatcher("user/userList.jsp");
        }

        else if (page.equalsIgnoreCase("userForm")){
            rd = request.getRequestDispatcher("user/userForm.jsp");
        }

        else if (page.equalsIgnoreCase("addUser")){
            User user = getRequestUser(request);
            this.userService.save(user);

            List<User> userList = this.userService.getUserList();
            request.setAttribute("userList",userList);
            request.setAttribute("msg","User Added ! ");
            rd = request.getRequestDispatcher("user/userList.jsp");
        }
        else if (page.equalsIgnoreCase("cancel")){
            List<User> userList = new UserServiceImpl().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/userList.jsp");
        }

        else if (page.equalsIgnoreCase("return")){
            rd = request.getRequestDispatcher("index.jsp");

        }
        else if (page.equalsIgnoreCase("delete")){
            int id = Integer.parseInt(request.getParameter("id"));
            new UserServiceImpl().deleteUser(id);
            request.setAttribute("msg", "User Successfully deleted..");
            List<User> userList = new UserServiceImpl().getUserList();
            request.setAttribute("userList", userList);
            rd = request.getRequestDispatcher("user/userList.jsp");

        }

        else if(page.equalsIgnoreCase("editForm")){
            int id = Integer.parseInt(request.getParameter("id"));
            User user = userService.getUserById(id);
            request.setAttribute("user", user);
            rd = request.getRequestDispatcher("user/updateUserForm.jsp");
        }
        else if (page.equalsIgnoreCase("updateUser")){
            User user = getRequestUser(request);

            int updateRowId = this.userService.update(user);

            if(updateRowId > 0) {
                request.setAttribute("msg", "User Successfully updated..");
                List<User> userList = new UserServiceImpl().getUserList();
                request.setAttribute("userList",userList);
                rd = request.getRequestDispatcher("user/userList.jsp");
            } else {
                request.setAttribute("msg", "User Update Failed!!!");
                request.setAttribute("user", user);
                rd = request.getRequestDispatcher("user/updateUserForm.jsp");
            }
        }
        rd.forward(request, response);
    }

    private User getRequestUser(HttpServletRequest request) {
        User user = new User();

        if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()){
            int id = Integer.parseInt(request.getParameter("id"));
            user.setId(id);
        }

        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String role=request.getParameter("role");

        user.setName(name);
        user.setPassword(password);
        user.setRole(role);
        return user;
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);

    }
}

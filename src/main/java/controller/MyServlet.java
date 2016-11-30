package controller;


import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Samson on 19/08/16.
 * mvn appengine:update
 * mvn appengine:devserver
 */
public class MyServlet extends HttpServlet {

    private static Logger logger = Logger.getLogger(MyServlet.class.getName());
    private UsersController uc = new UsersController();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        logger.log(Level.INFO, "doPost start...");
        logger.log(Level.INFO, "Username: " + username);
        logger.log(Level.INFO, "Password: " + password);
        logger.log(Level.INFO, "Checkbox: " + request.getParameter("rememberMe"));

        request.setAttribute("username", username);
        request.setAttribute("password", password);


        User user = uc.getUserByNameAndPassword(username, password);

        if (uc.isUser(user)) {
            request.setAttribute("role", user.getRole());
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/unknownUser.jsp").forward(request, response);
        }


        logger.log(Level.INFO, "doPost ended...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.log(Level.INFO, "doGet started...");
        logger.log(Level.INFO, "doGet ended...");
    }


}

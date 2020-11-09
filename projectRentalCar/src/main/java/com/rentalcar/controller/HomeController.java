package com.rentalcar.controller;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.UserDaoImpl;
import com.rentalcar.entity.User;
@WebServlet( urlPatterns = {""})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private UserDao userDao = UserDaoImpl.getInstance();
     
    public HomeController() {
        // Do Nothing
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("------------------------------SOno nel home controller");
       List<User> users = userDao.findAllUsers();
       //User user = userDao.findUserById(1);
        request.setAttribute("userList", users);
 
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

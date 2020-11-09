package com.rentalcar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.rentalcar.dao.UserDao;
import com.rentalcar.dao.impl.UserDaoImpl;
import com.rentalcar.entity.User;
 
@WebServlet("/user/register")
public class UserRegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L; //probabile problema?
 
    private UserDao userDao =UserDaoImpl.getInstance();
 
    public UserRegistrationController() {
        // Do Nothing
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        String custId = request.getParameter("id");
        String firstName = request.getParameter("nome");
        String lastName = request.getParameter("cognome");
        String email = request.getParameter("email");
       
 
        User user = new User(firstName, lastName, email);
 
        if (custId == null || custId == "")
           userDao.saveUser(user);
        else {
            int id = Integer.parseInt(custId);
            user.setId(id);
            userDao.updateUser(user);
        }
 
        response.sendRedirect(request.getContextPath() + "/");
    }
 
}
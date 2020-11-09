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
 
@WebServlet("/user/update")
public class UpdateUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public UpdateUserController() {
        // Do Nothing
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        String custId = request.getParameter("custId");
 
        if (custId == "" || custId == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            int id = Integer.parseInt(custId);
            UserDao userDao = UserDaoImpl.getInstance();
            User user = userDao.findUserById(id);
 
            request.setAttribute("user", user);
 
            request.getRequestDispatcher("/").forward(request, response);
        }
    }
}
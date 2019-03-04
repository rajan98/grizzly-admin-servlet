package com.grizzlystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;

/**
 * Servlet implementation class RedirectToAddProductServlet
 */
public class RedirectToAddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher = null;
	LoginService loginService = LoginServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToAddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		requestDispatcher = request.getRequestDispatcher("Vendor - AddProduct.jsp");
		requestDispatcher.forward(request, response);

	}


}

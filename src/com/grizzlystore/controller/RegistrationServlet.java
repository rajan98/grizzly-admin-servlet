package com.grizzlystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.service.EmployeeService;
import com.grizzlystore.service.EmployeeServiceImpl;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = LoginServiceImpl.getInstance();
	RequestDispatcher requestDispatcher = null;  
	EmployeeService service = new EmployeeServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = request.getParameter("fName");
		String userId = request.getParameter("userName");
		String userType = request.getParameter("userType");
		String password = request.getParameter("password");
		long contact = Long.parseLong(request.getParameter("contactNumber"));
		String address = request.getParameter("address");
		
	Profile employee = new Profile(userId,password,contact,userType,address);	
		int result = service.registerUser(employee);
		if(result==1)
		{
		requestDispatcher = request.getRequestDispatcher("Registered.html");
		   requestDispatcher.forward(request, response);
	}
		}
		

}

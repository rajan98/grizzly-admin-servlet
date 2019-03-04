package com.grizzlystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizzlystore.bean.Profile;
import com.grizzlystore.bean.Vendors;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;
import com.grizzlystore.service.VendorService;
import com.grizzlystore.service.VendorServiceImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = LoginServiceImpl.getInstance();
	VendorService vendorService = new VendorServiceImpl();
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    
    RequestDispatcher requestDispatcher = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = null;
		
		if(!loginService.authenticateUserId(userId))
		{
			requestDispatcher = request.getRequestDispatcher("LoginError2.html");
		    requestDispatcher.forward(request, response);
		}
		
		if(loginService.authenticateUserId(userId)&&loginService.getUserStatus(userId)>=3)
		{
			requestDispatcher = request.getRequestDispatcher("UserDeactivated.html");
			   requestDispatcher.forward(request, response);
		}
		
		
		else if(loginService.authenticate(userId,password))
		{
			if(loginService.getUserStatus(userId)<3)
			{
				if("A".equals(loginService.getUserType(userId, password)))
				{
					
				loginService.resetUserStatus(userId);
				session =  request.getSession();
				requestDispatcher = request.getRequestDispatcher("ViewProductsServlet");
				Profile profile = loginService.getUserProfile(userId);
				session.setAttribute("user", profile );
				session.setAttribute("type", "admin" );
				requestDispatcher.forward(request, response);
				}
				else if("V".equals(loginService.getUserType(userId, password)))
				{
					
					loginService.resetUserStatus(userId);
					session =  request.getSession();
					requestDispatcher = request.getRequestDispatcher("VendorViewProductsServlet");
					Vendors vendor = vendorService.getVendorById(userId);
					session.setAttribute("user", vendor );
					session.setAttribute("type", "vendor" );
					requestDispatcher.forward(request, response);
					
					}
			}
			
			else
			{
				requestDispatcher = request.getRequestDispatcher("UserDeactivated.html");
				   requestDispatcher.forward(request, response);
			}
		}
	
		
			else
			{
				//InvalidLoginACLockedException.setInvalidLoginCount(InvalidLoginACLockedException.getInvalidLoginCount()+1);
				
					loginService.setUserStatus(userId);
					
					requestDispatcher = request.getRequestDispatcher("Admin-Login.html");
				    requestDispatcher.forward(request, response);
			}
	}

}

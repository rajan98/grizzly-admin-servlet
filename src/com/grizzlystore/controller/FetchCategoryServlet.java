package com.grizzlystore.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizzlystore.bean.Category;
import com.grizzlystore.bean.Profile;
import com.grizzlystore.service.CategoryService;
import com.grizzlystore.service.CategoryServiceImpl;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;

/**
 * Servlet implementation class FetchCategoryServlet
 */
public class FetchCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LoginService loginService = LoginServiceImpl.getInstance();
    public FetchCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> allCategory = new ArrayList<Category>();
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(false);	
		allCategory.addAll(categoryService.getCategory());
		session.setAttribute("category", allCategory);
		//System.out.println(session.getAttribute("type").toString());
		if("admin".equals(session.getAttribute("type").toString()))
	
				{
		
		requestDispatcher = request.getRequestDispatcher("Admin-AddProduct.jsp");
		requestDispatcher.forward(request, response);
				}
		else
		{
			requestDispatcher = request.getRequestDispatcher("Vendor-AddProduct2.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}
	



}
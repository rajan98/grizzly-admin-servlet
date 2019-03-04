package com.grizzlystore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grizzlystore.bean.Product;
import com.grizzlystore.bean.Profile;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;
import com.grizzlystore.service.ProductService;
import com.grizzlystore.service.ProductServiceImpl;

public class AddProductServlet extends HttpServlet {
	LoginService loginService = LoginServiceImpl.getInstance();
	private static final long serialVersionUID = 1L;
	RequestDispatcher requestDispatcher = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String id= request.getParameter("productId");
		String category = request.getParameter("category");
		String name = request.getParameter("productName");
		String description = request.getParameter("productDescription");
		float price = Float.parseFloat(request.getParameter("productPrice"));
		ProductService productService = new ProductServiceImpl();
		String userId = request.getParameter("userId");
		String brand = request.getParameter("brand");
		String offer="0%";
		String rating="0";
		Product product = new Product(id,category,name,description,price,brand,offer,rating);
		 
		String result = productService.addProduct(product);
		
		if("success".equals(result) && "admin".equals(session.getAttribute("type").toString()))
			{
			requestDispatcher = request.getRequestDispatcher("ViewProductsServlet");
			requestDispatcher.forward(request, response);
			
	}
		else if("success".equals(result) && "vendor".equals(session.getAttribute("type").toString()))
		{
			requestDispatcher = request.getRequestDispatcher("VendorViewProductsServlet");
			requestDispatcher.forward(request, response);
		}
		
		else
		{
			requestDispatcher = request.getRequestDispatcher("Admin-AddProduct.jsp");
			Profile profile = loginService.getUserProfile(userId);
			request.setAttribute("productError", "Error! Product already exits" );
			requestDispatcher.forward(request, response);
			  
	}
	}
}
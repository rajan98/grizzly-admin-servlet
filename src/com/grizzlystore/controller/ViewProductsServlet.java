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

import com.grizzlystore.bean.Product;
import com.grizzlystore.bean.Profile;
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;
import com.grizzlystore.service.ProductService;
import com.grizzlystore.service.ProductServiceImpl;

public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = LoginServiceImpl.getInstance();

    public ViewProductsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ProductService productService = new ProductServiceImpl();
		List<Product> products = new ArrayList<Product>();
		RequestDispatcher requestDispatcher = null;
		products.addAll(productService.getAllProducts());
		HttpSession session = request.getSession(true);
		session.setAttribute("products", products);
	
		requestDispatcher = request.getRequestDispatcher("Admin-ListProducts.jsp");
		requestDispatcher.forward(request, response);
	}
	

	
}
package com.grizzlystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grizzlystore.bean.Product;
import com.grizzlystore.service.ProductService;
import com.grizzlystore.service.ProductServiceImpl;

/**
 * Servlet implementation class FetchProductServlet
 */
public class FetchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RequestDispatcher requestDispatcher = null;
		ProductService productService = new ProductServiceImpl();
		Product product =  productService.findProduct(id);
		requestDispatcher = request.getRequestDispatcher("Admin-ViewProduct.jsp");
		request.setAttribute("product", product);
		requestDispatcher.forward(request, response);
	}



}

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
 * Servlet implementation class DeleteProductServlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RequestDispatcher requestDispatcher;
		ProductService productService = new ProductServiceImpl();
		String result = productService.deleteProduct(id);
		if("deleted".equals(result)){
		request.setAttribute("products", productService.getAllProducts());
		requestDispatcher = request.getRequestDispatcher("Admin-ListProducts.jsp");
		requestDispatcher.forward(request, response);
		}
		System.out.print("Unable to delete");
	}

	
}
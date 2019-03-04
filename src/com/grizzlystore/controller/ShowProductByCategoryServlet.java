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
import com.grizzlystore.service.ProductService;
import com.grizzlystore.service.ProductServiceImpl;

/**
 * Servlet implementation class ShowProductByCategoryServlet
 */
public class ShowProductByCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductByCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String query = "Select * from product where category = '"+category+"'";
	
	ProductService productService = new ProductServiceImpl();
	List<Product> products = new ArrayList<Product>();
	RequestDispatcher requestDispatcher = null;
	HttpSession session = request.getSession(false);
	products.addAll(productService.filterProducts(query));
	session.setAttribute("products", products);
	
	
	
	if("admin".equals(session.getAttribute("type").toString()))
		
	{

		requestDispatcher = request.getRequestDispatcher("Admin-ListProducts.jsp");
		requestDispatcher.forward(request, response);
	}
	else
	{
		requestDispatcher = request.getRequestDispatcher("Vendor-AddProduct.jsp");
		requestDispatcher.forward(request, response);
	}
	
	}

}

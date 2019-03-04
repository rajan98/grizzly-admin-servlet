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
import com.grizzlystore.service.LoginService;
import com.grizzlystore.service.LoginServiceImpl;
import com.grizzlystore.service.ProductService;
import com.grizzlystore.service.ProductServiceImpl;

/**
 * Servlet implementation class SortByRatingServlet
 */
public class VendorSortByRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService = LoginServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorSortByRatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	String query="";	
	String order=request.getParameter("order");
	if(order.equals("LowToHigh"))
	{
	query = "Select * from product order by rating";
	}
	else
	{
	query = "Select * from product order by rating desc";
	}
	ProductService productService = new ProductServiceImpl();
	List<Product> products = new ArrayList<Product>();
	RequestDispatcher requestDispatcher = null;
	HttpSession session = request.getSession(true);
	products.addAll(productService.filterProducts(query));
	session.setAttribute("products", products);
	requestDispatcher = request.getRequestDispatcher("Vendor-AddProduct.jsp");
	requestDispatcher.forward(request, response);
		
		
	}



}

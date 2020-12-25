package ltweb.electronic_store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("nameP");
		ArrayList<Product> products = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		products = client.target(URLs.baseUrl + URLs.searchPath + "?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get(new GenericType<ArrayList<Product>>() {
				});
		request.getSession().setAttribute("products", products);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

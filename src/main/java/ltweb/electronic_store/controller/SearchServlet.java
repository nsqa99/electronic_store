package ltweb.electronic_store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.Settings;
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
		HttpSession session = request.getSession();
		String name = request.getParameter("nameP");
		String type = request.getParameter("type");
		int size = Settings.PAGE_SIZE;
		size = request.getParameter("size") == null ? size : Integer.parseInt(request.getParameter("size"));
		session.setAttribute("size", size);

		session.setAttribute("type", type);
		session.setAttribute("nameQuery", name);
		String pageStr = request.getParameter("page");
		int page;
		if (pageStr == null)
			page = 1;
		else
			page = Integer.parseInt(pageStr);
		session.setAttribute("page", page);
		String searchUrl = URLs.baseUrl + URLs.searchPath + "?name=" + name.replace(" ", "+") + "&page="
				+ Integer.toString(page) + "&size=" + Integer.toString(size);
		ArrayList<Product> products = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		Response res = client.target(searchUrl).request(MediaType.APPLICATION_JSON).get();
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			products = res.readEntity(new GenericType<ArrayList<Product>>() {
			});
		}

		int total = Integer.parseInt(res.getHeaderString("X-Total-Count"));
		session.setAttribute("total", total);

		session.setAttribute("products", products);
		request.getRequestDispatcher("dssp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

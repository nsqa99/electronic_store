package ltweb.electronic_store.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.utils.SecurityUtils;

@WebServlet("/resgister")
public class ResgisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResgisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password1 = null;
		try {
			password1 = SecurityUtils.md5Hashing(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		Customer cus = new Customer(username, password1, fullname, gender, phone, address);
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.resgisterPath).request(MediaType.APPLICATION_JSON)
				.post(Entity.json(cus));
		if (res.getStatus() != 400) {

			HttpSession session = request.getSession(true);
			session.setAttribute("successMessage", "Register success");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Error");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}

	}
}

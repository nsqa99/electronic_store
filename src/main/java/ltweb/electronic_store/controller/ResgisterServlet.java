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
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Customer;


public class ResgisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ResgisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone= request.getParameter("phone");
		String address = request.getParameter("address");
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
        Customer cus = new Customer(username, repassword, fullname, address, phone, gender);
		Client client = ClientBuilder.newClient();
		
		
		
		Response res = client.target(URLs.baseUrl + URLs.resgisterPath ).request(MediaType.APPLICATION_JSON).post(Entity.json(cus));
		
		 
	     
			
			if (res.getStatus()!= 400) {
				HttpSession session = request.getSession(true);
				session.setAttribute("successMessage", "Register success");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Error");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}

	}

}

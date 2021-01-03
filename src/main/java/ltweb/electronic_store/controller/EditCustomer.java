package ltweb.electronic_store.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Customer;

/**
 * Servlet implementation class EditCustomer
 */
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String Username = request.getParameter("Username");
		String Address = request.getParameter("Address");
		String SDT = request.getParameter("SDT");
		String gioitinh = request.getParameter("gioitinh");
		String PasswordNew = request.getParameter("PasswordNew");
		String ConfirmPassword = request.getParameter("ConfirmPassword");
		String Password = request.getParameter("Password");
		Customer cus;
		if(Password!= null) {
			if(ConfirmPassword.equals(PasswordNew)) {
				cus = new Customer(Username, name, PasswordNew, Address, SDT, gioitinh);
			}
		}
		else {
			cus = new Customer(Username, name, Address, SDT, gioitinh);
		}
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.getCart+  URLs.getCustomer +"?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(res);
		Customer ex = new Customer();
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			ex = res.readEntity(new GenericType<Customer>() {
			});
			 System.out.println("Khach hang"+ex.toString());
		}
		request.getSession().setAttribute("customer", ex);
		request.getRequestDispatcher("thongtincanhanEdit.jsp").forward(request, response);
	}

}

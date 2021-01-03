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
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Cart;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.DetailCart;

/**
 * Servlet implementation class EditInfoCus
 */
public class EditInfoCus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoCus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("idCustomer");
//		name = "1";
		System.out.println(name+"vvvvvvvvvvvname");
		Customer cus = new Customer();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.getCart+  URLs.getCustomer +"?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(res);
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			cus = res.readEntity(new GenericType<Customer>() {
			});
			 System.out.println("Khach hang"+cus.toString());
		}
		request.getSession().setAttribute("customer", cus);
		request.getRequestDispatcher("thongtincanhanEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

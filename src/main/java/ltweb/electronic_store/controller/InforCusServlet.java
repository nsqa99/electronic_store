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
import ltweb.electronic_store.model.Admin;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class InforCusServlet
 */
public class InforCusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InforCusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("cusname");
		System.out.println(username);
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl).path(URLs.INFOR_CUS_PATH).resolveTemplate("customername", username).request(MediaType.APPLICATION_JSON).get();
		ArrayList<Customer> customer = new ArrayList<>();
		
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			customer = res.readEntity(new GenericType<ArrayList<Customer>>() {
			});
		}
		
//		System.out.println(customer.size());
		request.getSession().setAttribute("in4cus", customer);
		request.getRequestDispatcher("thongtincanhan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

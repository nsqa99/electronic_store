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
import ltweb.electronic_store.model.ChitietHoadon;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class DetailOrderServlet
 */
public class DetailOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("idHD");
		ArrayList<ChitietHoadon> ct = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.searchDetailHoaDonPath +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			ct = res.readEntity(new GenericType<ArrayList<ChitietHoadon>>() {
			});
		}
		else {
			System.out.println(res.getStatus());
		}
		request.getSession().setAttribute("chitiet", ct);
		Order hd = new Order();
		Response res1 = client.target(URLs.baseUrl + URLs.searchHoaDonPath + URLs.searchHoaDonByIDPath +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			
			hd = res1.readEntity(new GenericType<Order>() {
			});
		}
		else {
			System.out.println(res.getStatus());
		}
		request.getSession().setAttribute("hoadon", hd);
		
		Customer cs = new Customer();
		Response res2 = client.target(URLs.baseUrl + URLs.searchHoaDonPath + URLs.searchKhachhangByIDHDPath +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res2.getStatus() != 400 && res1.getStatus() != 500) {
			
			cs = res2.readEntity(new GenericType<Customer>() {
			});
		}
		else {
			System.out.println(res.getStatus());
		}
		System.out.println(cs.toString());
		request.getSession().setAttribute("khachhang", cs);
		
		request.getRequestDispatcher("Chitietdonhang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package ltweb.electronic_store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class WebOrderServlet
 */
public class WebOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("idCustomer");
//		name = "1";
		System.out.println(name + "xxxxxxxxxxxx");
		ArrayList<DetailOrdes> detailOr = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.searchHoaDonPath + URLs.searchOrderCustomer +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			detailOr = res.readEntity(new GenericType<ArrayList<DetailOrdes>>() {
			});
			System.out.println("2222"+detailOr.toString());
		}

		request.getSession().setAttribute("detailOr", detailOr);
		request.getRequestDispatcher("listOrder(Cus).jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("idCustomer");
		name = "1";
		System.out.println("444444444444444444444444");
//		int ma = Integer.parseInt(name);
		Order or = new Order();
//		String total = request.getParameter("total");
//		ArrayList<DetailOrdes> detailOr = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.getCart + URLs.getOrder +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println("res weborderservlet 1 post "+ res);
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			or = res.readEntity(new GenericType<Order>() {
			});
			System.out.println("1 "+or.toString());
		}
		
//		Order order = new Order(idCust, createdDate, total, amount)
		Response res1 = client.target(URLs.baseUrl + URLs.getCart + URLs.getOrder2)
				.request(MediaType.APPLICATION_JSON).post(Entity.json(or));
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			or = res1.readEntity(new GenericType<Order>() {
			});
			System.out.println("2"+or.toString());
		}
		ArrayList<Product> proList = new ArrayList<Product>();
		Response res2 = client.target(URLs.baseUrl + URLs.getCart + URLs.getDetailOrder +"?name=" + name.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res2.getStatus() != 400 && res2.getStatus() != 500) {
			proList = res2.readEntity(new GenericType<ArrayList<Product>>() {
			});
			System.out.println("3"+proList.toString());
		}
//		request.getSession().setAttribute("list", proList);
		System.out.println("dat hang thanh cong");
		String nd = "Dat hang thanh cong";
		request.getSession().setAttribute("nd", nd);
		request.getRequestDispatcher("index_customer.jsp").forward(request, response);
		
		
	}

}

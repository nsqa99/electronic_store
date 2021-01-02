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
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class CartServlet1
 */
public class CartServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("1");
		name = "1";
		System.out.println(name+"vvvvvvvvvvvname");
		ArrayList<DetailCart> list = new ArrayList<>();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.getCart + URLs.getListProduct +"?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(res);
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			 list = res.readEntity(new GenericType<ArrayList<DetailCart>>() {
			});
			 System.out.println(list.toString());
		}

		Cart cart = new Cart();
//		Client client = ClientBuilder.newClient();
		Response res1 = client.target(URLs.baseUrl + URLs.getCart + URLs.getCartCreated +"?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(res1);
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			 cart = res1.readEntity(new GenericType<Cart>() {
			});
			 System.out.println(cart.toString());
		}
		Customer cus = new Customer();
//		Client client = ClientBuilder.newClient();
		Response res2 = client.target(URLs.baseUrl + URLs.getCart + URLs.getCustomer +"?name=" + name.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		System.out.println(res2);
		if (res2.getStatus() != 400 && res2.getStatus() != 500) {
			 cus = res2.readEntity(new GenericType<Customer>() {
			});
			 System.out.println(cus.toString());
		}
		request.getSession().setAttribute("products", list);
		request.getSession().setAttribute("cart", cart);
		request.getSession().setAttribute("customer", cus);
		request.getRequestDispatcher("Order.jsp").forward(request, response);
		// lấy mã khách hàng tìm mã giỏ hàng
		// từ mã giỏ hàng tìm các mã sản phẩm -> tính toán tổng tiền
		//tạo hóa đơn --> thêm vào list của cả khách hàng và admin
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

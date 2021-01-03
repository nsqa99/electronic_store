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
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.model.Rating;

/**
 * Servlet implementation class RatingServlet
 */
public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RatingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProduct = request.getParameter("idProduct");
		String idCustomer = request.getParameter("idCustomer");
		Product pro = new Product();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.getCart + URLs.getProduct + "?name=" + idProduct.trim())
				.request(MediaType.APPLICATION_JSON).get();
		if (res.getStatus() != 400 && res.getStatus() != 500) {
			pro = res.readEntity(new GenericType<Product>() {
			});
		}
		
		Rating rate = new Rating();
		String x = idProduct + " " + idCustomer;
		System.out.println(x);
		Response res1 = client.target(URLs.baseUrl + URLs.INSERT_RATING + "?name=" + x.replace(" ", "+"))
				.request(MediaType.APPLICATION_JSON).get();
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			rate = res1.readEntity(new GenericType<Rating>() {
			});
		}
		System.out.println("danh gia o day " + rate.toString());
		request.getSession().setAttribute("product", pro);
		request.getSession().setAttribute("rate", rate);
		request.getRequestDispatcher("reviewproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProduct = request.getParameter("idProduct");
		String idCustomer = request.getParameter("idCustomer");
		String star = request.getParameter("rate");
		String content = request.getParameter("content").trim();
		String x = idProduct + " " + idCustomer;
		String kt = request.getParameter("dg");
		System.out.println(kt+ "kt nay");
		Rating rate = new Rating(content, Integer.parseInt(idCustomer), Integer.parseInt(idProduct),
				Integer.parseInt(star.trim()));
		System.out.println(rate.toString());
		Client client = ClientBuilder.newClient();
		// kiêm tra ton tai danh gia chua
		boolean check = true;
		Response res1 = client.target(URLs.baseUrl + URLs.INSERT_RATING  + URLs.checkRating +"?name=" + x.replace(" ", "+")).request(MediaType.APPLICATION_JSON).get();
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			check = res1.readEntity(new GenericType<Boolean>() {
			});
		}
//		Product pro = new Product();
		if (kt != null) {
			// ton tai roi thi update
			Response res = client.target(URLs.baseUrl + URLs.INSERT_RATING).request(MediaType.APPLICATION_JSON)
					.put(Entity.json(rate));
			if (res.getStatus() != 400 && res.getStatus() != 500) {
				System.out.println("update thanh cong");
				System.out.println("check upstese"+ res);
//				rate = res.readEntity(new GenericType<Rating>() {
//				});
			}
		} else {
			Response res = client.target(URLs.baseUrl + URLs.INSERT_RATING).request(MediaType.APPLICATION_JSON)
					.post(Entity.json(rate));
			if (res.getStatus() != 400 && res.getStatus() != 500) {
				System.out.println("check ínesert"+ res);
				System.out.println("insert thanh cong");
//				rate = res.readEntity(new GenericType<Rating>() {
//				});
			}
		}

		request.getSession().setAttribute("product", rate);
//		request.getRequestDispatcher("reviewproduct.jsp").forward(request, response);
	}

}

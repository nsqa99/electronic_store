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

import com.sun.research.ws.wadl.Request;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.DetailCart;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Rating;

/**
 * Servlet implementation class DetailProductServlet
 */
public class DetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(id);
		Client client = ClientBuilder.newClient();
		Response res;
		Laptop lt = null;
		Mobile mb = null;
		res = client.target(URLs.baseUrl + URLs.productPath + "/" + id).request(MediaType.APPLICATION_JSON).get();
		lt = res.readEntity(Laptop.class);
		if (lt.getVGA() == null) {
			res = client.target(URLs.baseUrl + URLs.productPath + "/" + id).request(MediaType.APPLICATION_JSON).get();
			mb = res.readEntity(Mobile.class);
			lt = null;
		}
		
//		int danhgia = 5;
		ArrayList<Rating> listRating = new ArrayList<Rating>();
		Response res1 = client.target(URLs.baseUrl + URLs.productPath + URLs.getRating + "/" + id).request(MediaType.APPLICATION_JSON).get();
		if (res1.getStatus() != 400 && res1.getStatus() != 500) {
			listRating = res1.readEntity(new GenericType<ArrayList<Rating>>() {
			});
			 System.out.println(listRating.toString());
		}
		
		
		
		if (res.getStatus() != 404) {
			request.getSession().setAttribute("oneProduct", lt == null ? mb : lt);
			request.getSession().setAttribute("pType", lt == null ? "mobile" : "laptop");
			request.getSession().setAttribute("rating", listRating);
			response.sendRedirect(request.getContextPath() + "/chitietsp.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

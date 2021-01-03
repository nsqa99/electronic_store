package ltweb.electronic_store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String name = request.getParameter("nameP");
		double price = Double.parseDouble(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		String image = request.getParameter("image");
		String screen = request.getParameter("screen");
		String os = request.getParameter("os");
		String cpu = request.getParameter("cpu");
		String ram = request.getParameter("ram");
		String rom = request.getParameter("rom");
		String battery = request.getParameter("battery");
		String warranty = request.getParameter("warranty");
		String camera = request.getParameter("camera");
		String vga = request.getParameter("vga");
		String frontCam = request.getParameter("frontCam");
		String backCam = request.getParameter("backCam");

		Product p = new Product(name, price, price, amount, image, screen, os, cpu, ram, rom, battery, warranty);
		Laptop lt = null;
		Mobile mb = null;

		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.productPath).request(MediaType.APPLICATION_JSON)
				.post(Entity.json(p));
		if (res.getStatus() != 500) {
			p = res.readEntity(Product.class);
		} else
			response.sendRedirect("Adminpage.jsp");

		System.out.println(p.getIdProduct());

		if (type.equals("laptop")) {
			lt = new Laptop(p.getIdProduct(), name, price, price, amount, image, screen, os, cpu, ram, rom, battery,
					warranty, camera, vga);
		} else {
			mb = new Mobile(p.getIdProduct(), name, price, price, amount, image, screen, os, cpu, ram, rom, battery,
					warranty, frontCam, backCam);
		}

		Response res1 = null;
		if (lt != null) {
			res1 = client.target(URLs.baseUrl + URLs.laptopPath).request(MediaType.APPLICATION_JSON)
					.post(Entity.json(lt));
		} else if (mb != null) {
			res1 = client.target(URLs.baseUrl + URLs.mobilePath).request(MediaType.APPLICATION_JSON)
					.post(Entity.json(mb));
		}

		if (res.getStatus() != 500 && res1.getStatus() != 500) {
			System.out.println("yay");
			response.sendRedirect("Adminpage.jsp");
		} else {
			System.out.println("NOOO");
		}
	}

}

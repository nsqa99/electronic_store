package ltweb.electronic_store.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.research.ws.wadl.Request;

import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Product;

@WebServlet("/products")
public class ProcductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		}
		catch(NumberFormatException e) {
		}
		String anhSP = req.getParameter("anhSP");
		String tenSP = req.getParameter("tenSP");
		String motaSP = req.getParameter("motaSP");
		double giaSP = Double.parseDouble(req.getParameter("giaSP"));
		int soluongSP = Integer.parseInt(req.getParameter("soluongSP"));
		String manhinhSP = req.getParameter("manhinhSP");
		String hdhSP = req.getParameter("hdhSP");
		String cpuSP = req.getParameter("cpuSP");
		String ramSP = req.getParameter("ramSP");
		String romSP = req.getParameter("romSP");
		String pinSP = req.getParameter("pinSP");
		String baohanhSP = req.getParameter("baohanhSP");
		String cameraSP = req.getParameter("cameraSP");
		String vgaSP = req.getParameter("vgaSP");
		String camtruocSP = req.getParameter("camtruocSP");
		String camsauSP = req.getParameter("camsauSP");
		String loaiSP = req.getParameter("loaiSP");
		
		Product product = new Product(tenSP, giaSP, giaSP, soluongSP, anhSP,manhinhSP,hdhSP,cpuSP,ramSP,romSP,pinSP,baohanhSP, loaiSP);
		Laptop laptop;
		Mobile mobile;
		Client client = ClientBuilder.newClient();
		client.target(URLs.baseUrl+URLs.productPath).request(MediaType.APPLICATION_JSON).post(Entity.json(product));
		if(loaiSP.equals("laptop")) {
			 laptop = new Laptop(product,cameraSP,vgaSP);
			 Response res = client.target(URLs.baseUrl + URLs.productPath + URLs.laptopPath)
						.request(MediaType.APPLICATION_JSON).post(Entity.json(laptop));
		}
		else {
			mobile = new Mobile(product,camtruocSP,camsauSP);
			Response res = client.target(URLs.baseUrl + URLs.productPath +URLs.mobilePath)
					.request(MediaType.APPLICATION_JSON).post(Entity.json(mobile));
		}
		
		req.getRequestDispatcher("Adminpage.jsp").forward(req, resp);
	}

}

package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javassist.bytecode.LocalVariableTypeAttribute;
import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Product;

@Path("products/laptop")
@Produces(MediaType.APPLICATION_JSON)
public class LaptopResource {
	private ProductDAO dao = new ProductDAO();
	@POST
	 public Response addProduct(Laptop laptop) {
		ArrayList<Product> list = dao.getAll();
		laptop.setIdProduct(list.get(list.size()-1).getIdProduct());
		 int res = dao.addLaptop(laptop);
		 if (res == 1) return Response.status(201).build();
		 return Response.status(500).build();
	 }
}

package ltweb.electronic_store.restapi;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import ltweb.electronic_store.dao.*;
import ltweb.electronic_store.model.*;

@Path("products/mobile")
@Produces(MediaType.APPLICATION_JSON)
public class MobileResoure {
	private ProductDAO dao = new ProductDAO();
	@POST
	 public Response addProduct(Mobile mobile) {
		ArrayList<Product> list = dao.getAll();
		mobile.setIdProduct(list.get(list.size()-1).getIdProduct());
		 int res = dao.addMobile(mobile);
		 if (res == 1) return Response.status(201).build();
		 return Response.status(500).build();
	 }
}
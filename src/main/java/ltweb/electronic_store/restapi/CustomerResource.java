package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CartDAO;
import ltweb.electronic_store.model.DetailCart;


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
	private CartDAO dao = new CartDAO();

	
	@GET
//	@Path("/listProduct")
	public Response Customer(@QueryParam("name") String name) {
		System.out.println("kkkkkkkkkkkkkkkkkkkkk");
		System.out.println(name + " name");
		int ma = Integer.parseInt(name);
//		Customer cus = new Customer();
		System.out.println(ma);
//		if (list != null) {
//			System.out.println("api");
//			System.out.println(list);
//			return Response.ok().entity(list).build();
			
//		} else {
//			return Response.status(500).build();
//		}
		return null;
	}
}

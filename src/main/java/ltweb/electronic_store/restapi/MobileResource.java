package ltweb.electronic_store.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Mobile;

@Path("mobiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MobileResource {

	ProductDAO dao = new ProductDAO();

	@POST
	public Response addMobile(Mobile mobile) {
		int res = dao.addMobile(mobile);
		if (res != 0) {
			return Response.status(201).entity(mobile).build();
		}
		return Response.status(500).entity("Cannot add mobile").build();
	}

}

package ltweb.electronic_store.restapi;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Laptop;

@Path("laptops")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LaptopResource {

	ProductDAO dao = new ProductDAO();

	@POST
	public Response addLaptop(Laptop laptop) {
		int res = dao.addLaptop(laptop);
		if (res != 0) {
			return Response.status(201).entity(laptop).build();
		}
		return Response.status(500).entity("Cannot add laptop").build();
	}

}
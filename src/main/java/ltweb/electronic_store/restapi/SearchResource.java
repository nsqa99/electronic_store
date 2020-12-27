package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Product;

@Path("search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
	private ProductDAO dao = new ProductDAO();

	@GET
	public Response searchAllByName(@QueryParam("name") String name, @QueryParam("page") int page,
			@QueryParam("size") int size) {
		ArrayList<Product> products = new ArrayList<Product>();
		products = dao.getByName(name);
		int start = (page - 1) * size;
		int end = page * size > products.size() ? products.size() : page * size;
		if (products != null) {
			return Response.ok().entity(new ArrayList<>(products.subList(start, end)))
					.header("X-Total-Count", products.size()).build();
		} else {
			return Response.status(500).build();
		}
	}

}

package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Product;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

	private ProductDAO dao = new ProductDAO();

	@GET
	public Response getProducts() {
		ArrayList<Product> products = dao.getAll();
		if (products != null && products.size() != 0) {
			return Response.ok().entity(products).build();
		} else {
			return Response.status(404).build();
		}
	}

}

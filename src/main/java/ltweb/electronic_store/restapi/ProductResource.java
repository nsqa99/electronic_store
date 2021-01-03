package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ProductDAO;
import ltweb.electronic_store.model.Laptop;
import ltweb.electronic_store.model.Mobile;
import ltweb.electronic_store.model.Product;
import ltweb.electronic_store.model.Rating;

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

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") int id) {
		ArrayList products = dao.getProductByID(id);
		if (products.size() == 0)
			return Response.status(404).entity("Product not found").build();
		Laptop lt = null;
		Mobile mb = null;
		if (products.get(0) instanceof Laptop) {
			lt = (Laptop) products.get(0);
		} else
			mb = (Mobile) products.get(0);
		if (lt == null && mb == null)
			return Response.status(404).entity("Product not found").build();
		return Response.ok().entity((lt == null ? mb : lt)).build();
		// return Response.ok().entity(products).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		int res = dao.addProduct(product);

		if (res != 0) {
			Product p = dao.getOneByName(product.getName());
			return Response.status(201).entity(p).build();
		}
		return Response.status(500).entity("Cannot add product").build();
	}

	
	@GET
	@Path("/getRating")
	public Response getRating(@PathParam("idSP") String id) {
		int ma = Integer.parseInt(id);
		ArrayList<Rating> list = dao.getAllRating(ma);
		if (list != null) {
			System.out.println("api");
			System.out.println(list);
			return Response.ok().entity(list).build();
			
		} else {
			return Response.status(500).build();
		}
	}
}

package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CustomerDAO;
import ltweb.electronic_store.model.Admin;
import ltweb.electronic_store.model.Customer;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class InforCustResource {

	CustomerDAO dao = new CustomerDAO();
	@GET
	@Path("{customername}")
	public Response getCustomerByName(@PathParam("customername") String customername) {
		
		
		ArrayList<Customer> customer = dao.getCustByName(customername);
		System.out.println("api");
		if (customer != null) {
			return Response.ok().entity(customer).build();
		} else {
			return Response.status(404).build();
		}
	}
}

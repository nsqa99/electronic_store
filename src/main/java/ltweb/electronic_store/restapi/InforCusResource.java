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
public class InforCusResource {

	CustomerDAO dao = new CustomerDAO();
	@GET
	@Path("{customerId}")
	public Response getCustomerByID(@PathParam("customerId") String customerid) {
		
		int ID = Integer.parseInt(customerid);
		ArrayList<Customer> customer = dao.getCustByID(ID);
		if (customer != null && customer.size() != 0) {
			return Response.ok().entity(customer).build();
		} else {
			return Response.status(404).build();
		}
	}
}

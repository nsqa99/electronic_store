package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CustomerDAO;
import ltweb.electronic_store.model.Customer;

@Path("/resgister")
@Produces(MediaType.APPLICATION_JSON)
	public class CustomerResource {
	private CustomerDAO dao = new CustomerDAO();
	@POST
	 public Response resgister(Customer cus) throws  ClassNotFoundException {
				 int res = dao.addCust(cus);
				 if (res == 1) return Response.status(201).build();
				 return Response.status(500).build();
			 }
 		
    }





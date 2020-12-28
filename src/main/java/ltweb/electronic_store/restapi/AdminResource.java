package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.AdminDAO;
import ltweb.electronic_store.model.Admin;


@Path("admin")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdminResource {
	private AdminDAO dao = new AdminDAO();
	
	@GET
	public Response getAdmin() {
		ArrayList<Admin> admin = dao.getAll();
		if (admin != null && admin.size() != 0) {
			return Response.ok().entity(admin).build();
		} else {
			return Response.status(404).build();
		}
	}

	
	
}

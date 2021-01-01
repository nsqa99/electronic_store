package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.AdminDAO;
import ltweb.electronic_store.model.Admin;

@Path("delete")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteAdminResource {
	
	
private AdminDAO dao = new AdminDAO();
	
	@GET
	public Response deleteAdmin(int ID) {
		boolean delete = dao.deleteByID(ID);
		if (delete == true) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}
}

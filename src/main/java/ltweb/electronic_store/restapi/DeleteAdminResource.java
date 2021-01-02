package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.AdminDAO;
import ltweb.electronic_store.model.Admin;

@Path("deletead")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeleteAdminResource {
	
	
private AdminDAO dao = new AdminDAO();
	
	@DELETE
	@Path("{adminId}")
	public Response deleteAdmin(@PathParam("adminId") String adminid) {
		int ID = Integer.parseInt(adminid);
		System.out.println(ID);
		boolean delete = dao.deleteByID(ID);
		if (delete == true) {
			return Response.ok().entity(adminid).build();
		} else {
			return Response.status(500).build();
		}
	}
}

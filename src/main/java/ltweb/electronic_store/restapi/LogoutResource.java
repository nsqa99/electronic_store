package ltweb.electronic_store.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("logout")
@SecuredPath
public class LogoutResource {

	@GET
	public Response logout() {
		return Response.ok().entity("Verified").build();
	}

}

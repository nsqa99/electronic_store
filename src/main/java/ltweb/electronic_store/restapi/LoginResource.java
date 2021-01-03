package ltweb.electronic_store.restapi;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CustomerDAO;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.utils.SecurityUtils;

@Path("login")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
	private CustomerDAO dao = new CustomerDAO();

	@POST
	public Response login(JsonObject data) {
		Customer c = null;
		String username = data.getString("username");
		String password = data.getString("password");
		c = dao.getCust(username, password);
		if (c != null) {
			String token = SecurityUtils.createJWT(username);
			return Response.ok().entity("Login success").header("Authorization", "Bearer" + " " + token).build();
		}

		return Response.status(401).entity("Unauthorized").build();
	}

}

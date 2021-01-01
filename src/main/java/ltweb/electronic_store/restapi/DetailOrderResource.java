package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.ChitietHoaDonDAO;
import ltweb.electronic_store.model.ChitietHoadon;

@Path("chitiethoadon")
@Produces(MediaType.APPLICATION_JSON)
public class DetailOrderResource {
	private ChitietHoaDonDAO dao = new ChitietHoaDonDAO();
	@GET
	public Response searchAllByID(@QueryParam("name") String name) {
		int ma = Integer.parseInt(name);
		ArrayList<ChitietHoadon> ct = dao.getByIDHD(ma);
		if (ct != null) {
			System.out.println("api quan trong 3");
			System.out.println(ct);
			return Response.ok().entity(ct).build();
			
		} else {
			return Response.status(500).build();
		}
	}
}

package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.HoadonDAO;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.Order;

@Path("/hoadon")
@Produces(MediaType.APPLICATION_JSON)
public class HoadonResource {
	
	
		private HoadonDAO dao = new HoadonDAO();

		@GET
		@Path("/Allhoadon")
		public Response searchAll() {
			ArrayList<Order> order = dao.getAll();
			if (order != null) {
				System.out.println("api");
				System.out.println(order);
				return Response.ok().entity(order).build();
				
			} else {
				return Response.status(500).build();
			}
		}
		
		
		@GET
		@Path("/hoadonByID")
		public Response getHDByID(@QueryParam("name") String name) {
			int ma = Integer.parseInt(name);
			Order order = dao.getHDByIDHD(ma);
			if (order != null) {
				return Response.ok().entity(order).build();
				
			} else {
				return Response.status(500).build();
			}
		}
		@GET
		@Path("/KHByHD")
		public Response getKHByIDHD(@QueryParam("name") String name) {
			System.out.println(name+" name nhan");
			int ma = Integer.parseInt(name);
			Customer cs = dao.getKHByIDHD(ma);
			if (cs != null) {
				System.out.println("api 2");
				System.out.println(cs.toString());
				return Response.ok().entity(cs).build();
				
			} else {
				return Response.status(500).build();
			}
		}
		
}

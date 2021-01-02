package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.OrderDAO;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Order;

@Path("/hoadon")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
	
	
		private OrderDAO dao = new OrderDAO();

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
		@GET
		@Path("/orderByCustomer")
		public Response getOrderByCustomer(@QueryParam("name") String name) {
			System.out.println("dfthgrtgdkffjgoie");
			int ma = Integer.parseInt(name);
			System.out.println(ma+" ma");
			ArrayList<DetailOrdes> list = dao.getAllDetailByIDOrder(ma);
//			System.out.println(order.toString());
			if (list != null) {
				System.out.println("Doi tuong"+ list.toString());
				System.out.println(Response.ok().entity(list).build());
				return Response.ok().entity(list).build();
				
			} else {
				return Response.status(500).build();
			}
		}
		
		
		
}

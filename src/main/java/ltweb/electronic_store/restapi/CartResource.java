package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CartDAO;
import ltweb.electronic_store.dao.OrderDAO;
import ltweb.electronic_store.model.Cart;
import ltweb.electronic_store.model.Customer;
import ltweb.electronic_store.model.DetailCart;
import ltweb.electronic_store.model.DetailOrdes;
import ltweb.electronic_store.model.Order;
import ltweb.electronic_store.model.Product;


@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {
	private CartDAO dao = new CartDAO();

	// lấy giỏ hàng hàng dựa vào mã khách hàng
	@GET
	@Path("/listProduct")
	public Response searchAll(@QueryParam("name") String name) {
		System.out.println("kkkkkkkkkkkkkkkkkkkkk");
		System.out.println(name + " name");
		int ma = Integer.parseInt(name);
		ArrayList<DetailCart> list = dao.getDetailCart(ma);
		System.out.println(ma);
		if (list != null) {
			System.out.println("api");
			System.out.println(list);
			return Response.ok().entity(list).build();
			
		} else {
			return Response.status(500).build();
		}
	}
		
		@GET
		@Path("/cartCreated")
		public Response getCart(@QueryParam("name") String name) {
			System.out.println(name + " namemmmmmmmmmmmmmmm");
			int ma = Integer.parseInt(name);
			Cart cart = dao.setCart(ma);
			System.out.println(cart.toString());
			System.out.println(ma);
			if (cart != null) {
				System.out.println("api");
				System.out.println(cart.toString());
				return Response.ok().entity(cart).build();
				
			} else {
				return Response.status(500).build();
			}
			
	}
		@GET
		@Path("/cartCustomer")
		public Response getCustomer(@QueryParam("name") String name) {
			System.out.println(name + " namemmmmmmmmmmmmmmm");
			int ma = Integer.parseInt(name);
			
			Customer cus = dao.getCustomer(ma);
			System.out.println(cus.toString());
			System.out.println(ma);
			if (cus != null) {
				System.out.println("api");
				System.out.println(cus.toString());
				return Response.ok().entity(cus).build();
				
			} else {
				return Response.status(500).build();
			}
		}
		@GET
		@Path("/order1")
		public Response getOrder(@QueryParam("name") String name) {
			System.out.println(name + " mmmmmm");
			int ma = Integer.parseInt(name);
			Order or = dao.getOrder(ma);
			System.out.println(or.toString());
			System.out.println(ma);
			if (or != null) {
				System.out.println("api");
				System.out.println(or.toString());
				return Response.ok().entity(or).build();
				
			} else {
				return Response.status(500).build();
			}
			
	}
		@POST
		@Path("/order2")
		public Response createOrder(Order name) {
			System.out.println(name + " nam");
//			int ma = Integer.parseInt(name);
			Order or = dao.createOrder(name);
			System.out.println(or.toString());
//			System.out.println(ma);
			if (or != null) {
				System.out.println("api");
				System.out.println(or.toString());
				return Response.ok().entity(or).build();
				
			} else {
				return Response.status(500).build();
			}
			
	}
	@GET
	// lấy danh sach san pham nhu chi tiet hoa don
	@Path("/detailOrder")
	public Response getHDByID(@QueryParam("name") String name) {
		int ma = Integer.parseInt(name);
		Product pro = dao.getProductbyID(ma);
		System.out.println(pro.toString());
		if (pro != null) {
			return Response.ok().entity(pro).build();
			
		} else {
			return Response.status(500).build();
		}
	}
//	
	@GET
	@Path("/ByIDProduct")
	public Response getProduct(@QueryParam("name") String name) {
		System.out.println("dfthgrtgdkffjgoie");
		int ma = Integer.parseInt(name);
		System.out.println(ma+" ma");
		Product pro = dao.getProductbyID(ma);
//		System.out.println(order.toString());
		if (pro != null) {
			System.out.println("Doi tuong"+ pro.toString());
			System.out.println(Response.ok().entity(pro).build());
			return Response.ok().entity(pro).build();
			
		} else {
			return Response.status(500).build();
		}
	}
//	
//	@GET
//	@Path("/KHByHD")
//	public Response getKHByIDHD(@QueryParam("name") String name) {
//		System.out.println(name+" name nhan");
//		int ma = Integer.parseInt(name);
//		Customer cs = dao.getKHByIDHD(ma);
//		if (cs != null) {
//			System.out.println("api 2");
//			System.out.println(cs.toString());
//			return Response.ok().entity(cs).build();
//			
//		} else {
//			return Response.status(500).build();
//		}
//	}
		
}

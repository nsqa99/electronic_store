package ltweb.electronic_store.restapi;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.dao.CartDAO;
import ltweb.electronic_store.dao.RatingDAO;
import ltweb.electronic_store.model.DetailCart;
import ltweb.electronic_store.model.Rating;


@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
public class RatingResource {
	private RatingDAO dao = new RatingDAO();

	// lấy giỏ hàng hàng dựa vào mã khách hàng
	@POST
//	@Path("/listProduct")
	public Response searchAll(Rating rate) {
//		int ma = Integer.parseInt(name);
		boolean check = dao.createRating(rate);
//		System.out.println(ma);
		if (check) {
			System.out.println("api");
//			System.out.println(list);
			return Response.ok().entity(check).build();
			
		} else {
			return Response.status(500).build();
		}
	}
	@PUT
//	@Path("/listProduct")
	public Response updateRating(Rating rate) {
//		int ma = Integer.parseInt(name);
		boolean check = dao.updateRating(rate);
//		System.out.println(ma);
		if (check) {
//			System.out.println(list);
			return Response.ok().entity(check).build();
			
		} else {
			return Response.status(500).build();
		}
	}
	@GET
//	@Path("/listProduct")
	public Response getRating(@QueryParam("name") String name) {
		String t[] = name.split(" ");
		int maKH = Integer.parseInt(t[1].trim());
		int maSP = Integer.parseInt(t[0].trim());
		Rating rate = dao.getRating(maKH, maSP);
		if (rate != null) {
			return Response.ok().entity(rate).build();
			
		} else {
			return Response.status(500).build();
		}
	}
	
	@GET
	@Path("/checkRating")
	public Response check(@QueryParam("name") String name) {
		String t[] = name.split(" ");
		int maKH = Integer.parseInt(t[1].trim());
		int maSP = Integer.parseInt(t[0].trim());
		System.out.println(maKH  + " " + maSP);
		boolean check = dao.checkRating(maKH, maSP);
		if (check) {
			return Response.ok().entity(check).build();
			
		} else {
			return Response.status(500).build();
		}
	}
}

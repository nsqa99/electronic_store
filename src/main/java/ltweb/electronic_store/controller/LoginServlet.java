package ltweb.electronic_store.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.Settings;
import ltweb.electronic_store.contants.URLs;
import ltweb.electronic_store.utils.CookieUtils;
import ltweb.electronic_store.utils.SecurityUtils;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (CookieUtils.isAuthenCookieAvailable(request, (String) request.getSession().getAttribute("auth-token"))) {
			response.sendRedirect("index.jsp");
		} else
			response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String pw = null;
		try {
			pw = SecurityUtils.md5Hashing(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonObject data = Json.createObjectBuilder().add("username", username).add("password", pw).build();
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.loginPath).request().post(Entity.json(data));
		if (res.getStatus() != 401) {
			String token = res.getHeaderString(Settings.AUTHENTICATION_HEADER_KEY);
			String tokenAuth = null;
			if (token != null) {
				tokenAuth = token.substring(Settings.AUTHENTICATION_PREFIX.length());
				request.getSession().setAttribute("auth-token", tokenAuth);
			}
			request.getSession().setAttribute("username", username);
			Cookie tokenCookie = CookieUtils.setCookie(tokenAuth);
			response.addCookie(tokenCookie);

			response.sendRedirect("index.jsp");
		} else {
			doGet(request, response);
		}
	}

}

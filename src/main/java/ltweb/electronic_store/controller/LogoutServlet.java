package ltweb.electronic_store.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import ltweb.electronic_store.contants.Settings;
import ltweb.electronic_store.contants.URLs;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("auth-token");
		Client client = ClientBuilder.newClient();
		Response res = client.target(URLs.baseUrl + URLs.logoutPath).request()
				.header(Settings.AUTHENTICATION_HEADER_KEY, Settings.AUTHENTICATION_PREFIX + token).get();
		if (res.getStatus() != 401) {
			session.removeAttribute("auth-token");
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("auth_token")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		response.sendRedirect(request.getContextPath() + "/login");
	}

}

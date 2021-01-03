package ltweb.electronic_store.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	public static final int COOKIE_TTL = 60 * 60 * 24;

	public static Cookie setCookie(String token) {
		Cookie tokenCookie = new Cookie("auth_token", token);
		tokenCookie.setMaxAge(COOKIE_TTL);
		return tokenCookie;
	}

	public static boolean isAuthenCookieAvailable(HttpServletRequest request, String authToken) {
		Cookie[] cookies = request.getCookies();

		Cookie tokenCookie = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("auth_token") && cookie.getValue().equals(authToken)) {
					// System.out.print("Yo");
					tokenCookie = cookie;
				}
			}
		}

		return tokenCookie != null;
	}
}

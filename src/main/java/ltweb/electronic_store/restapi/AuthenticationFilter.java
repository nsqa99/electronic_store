package ltweb.electronic_store.restapi;

import java.io.IOException;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import ltweb.electronic_store.contants.Settings;
import ltweb.electronic_store.utils.SecurityUtils;

@SecuredPath
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	private static final String REALM = "electronic_store_d17_ptit";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		List<String> authHeaders = requestContext.getHeaders().get(Settings.AUTHENTICATION_HEADER_KEY);
		if (authHeaders != null && authHeaders.size() > 0) {
			String authToken = authHeaders.get(0);

			if (!isTokenBasedAuthentication(authToken)) {
				abortWithUnauthorized(requestContext);
			} else {
				String token = authToken.substring(Settings.AUTHENTICATION_PREFIX.length());
				if (!SecurityUtils.validateToken(token)) {
					abortWithUnauthorized(requestContext);
				}
			}
			return;

		} else {
			abortWithUnauthorized(requestContext);
		}
	}

	private boolean isTokenBasedAuthentication(String authorizationHeader) {

		return authorizationHeader != null
				&& authorizationHeader.toLowerCase().startsWith(Settings.AUTHENTICATION_PREFIX.toLowerCase());
	}

	private void abortWithUnauthorized(ContainerRequestContext requestContext) {

		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, Settings.AUTHENTICATION_PREFIX + " realm=\"" + REALM + "\"")
				.entity("Token not verified").build());
	}

}

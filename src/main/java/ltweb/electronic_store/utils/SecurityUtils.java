package ltweb.electronic_store.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class SecurityUtils {
	private static final String serverName = "elec_server";

	public static String md5Hashing(String pass) throws NoSuchAlgorithmException {
		MessageDigest alg = MessageDigest.getInstance("MD5");
		alg.reset();
		alg.update(pass.getBytes());
		byte[] digest = alg.digest();
		StringBuffer hashedpasswd = new StringBuffer();
		String hx;
		for (int i = 0; i < digest.length; i++) {
			hx = Integer.toHexString(0xFF & digest[i]);
			// 0x03 is equal to 0x3, but we need 0x03 for our md5sum
			if (hx.length() == 1) {
				hx = "0" + hx;
			}
			hashedpasswd.append(hx);
		}
		return hashedpasswd.toString();
	}

	public static String createJWT(String username) {
		Algorithm algorithm = Algorithm.HMAC256(username);
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 15);
		String token = JWT.create().withIssuer(serverName).withExpiresAt(now.getTime()).sign(algorithm);
		return token;
	}

	public static boolean validateToken(String token) {

		String issuer = null;
		Date expireTime = null;

		try {
			DecodedJWT jwt = JWT.decode(token);
			issuer = jwt.getIssuer();
			expireTime = jwt.getExpiresAt();
			Date now = Calendar.getInstance().getTime();
			if (now.after(expireTime) || !issuer.equals(serverName)) {
				return false;
			}

		} catch (JWTDecodeException exception) {
			// Invalid token
		}
		return true;
	}

}

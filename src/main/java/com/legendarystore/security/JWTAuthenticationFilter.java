package com.legendarystore.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.legendarystore.model.Customer;
import lombok.Getter;
import lombok.ToString;

import static com.legendarystore.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	private long expirationTime;
	private String secret;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, long expirationTime,
			String secret) {
		this.authenticationManager = authenticationManager;
		this.expirationTime = expirationTime;
		this.secret = secret;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			LoginCredentials creds = new ObjectMapper().readValue(req.getInputStream(), LoginCredentials.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String token = JWT.create().withSubject(((Customer) auth.getPrincipal()).getUsername()).withClaim("role", ((List<GrantedAuthority>) auth.getAuthorities()).get(0).getAuthority())
				.withExpiresAt(new Date(System.currentTimeMillis() + Long.valueOf(expirationTime)))
				.sign(Algorithm.HMAC512(secret.getBytes()));
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}

	@ToString
	@Getter
	private static class LoginCredentials {
		private String username;
		private String password;
	}

}

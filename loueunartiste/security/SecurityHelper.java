package fr.formation.loueunartiste.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class SecurityHelper {

    public static Long accountId() {
	JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder
		.getContext().getAuthentication();
	return Long.valueOf(token.getName());
    }

}

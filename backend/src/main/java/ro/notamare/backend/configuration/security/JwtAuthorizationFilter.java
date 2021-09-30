package ro.notamare.backend.configuration.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserPrincipalService userPrincipalService;
    private final JwtHandler jwtHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = parseJwtFromRequest(request);
        if (!StringUtils.isEmpty(jwt)) {
            DecodedJWT decodedJWT = jwtHandler.verify(jwt);

            String email = decodedJWT.getClaim("email").asString();
            UserDetails principal = userPrincipalService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String parseJwtFromRequest(HttpServletRequest request) {
        String authorizationValue = request.getHeader("Authorization");
        if (StringUtils.hasText(authorizationValue) && authorizationValue.startsWith("Bearer "))
            return authorizationValue.substring(7);
        return null;
    }
}

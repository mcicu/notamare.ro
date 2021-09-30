package ro.notamare.backend.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import ro.notamare.backend.entities.AbstractUser;

import java.util.Date;

@Component
public class JwtHandler {

    private String secret = "injected-secret";
    private Algorithm hmac256Algorithm = Algorithm.HMAC256(secret);
    private JWTVerifier jwtVerifier = JWT.require(hmac256Algorithm).build();

    public DecodedJWT verify(String jwt) {
        return jwtVerifier.verify(jwt);
    }

    public String create(AbstractUser user) {
        return JWT.create()
                .withIssuedAt(new Date())
                .withSubject(user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("name", user.getName())
                .sign(hmac256Algorithm);
    }
}

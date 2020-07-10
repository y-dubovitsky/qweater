package space.dubovitsky.jwtapp.security.jwt;

import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import space.dubovitsky.jwtapp.model.Role;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Класс, который генерирует Токен(т.е. клиент отправялет запрос на сервер, с именем и паролем, сервер ищет у себя такого пользователя и если он найден
 * генерирует токен и передает его пользователю в ответе, дальше уже пользователь при общении с сервером в запросе передает этот токен, чтобы сервер
 * мог пользователя идентифицировать)
 */
@Component
public class JwtTokenProvider {

    @Value("${jwt.token.secret}")
    private String secret;

    @Value("${jwt.token.expired}")
    private long expired; //* Какое время сгенерированный токен будет валидным

    private final UserDetailsService userDetailsService;

    public JwtTokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostConstruct
    protected void init() {
        secret = Base64.encodeBase64String(secret.getBytes());
    }

    public String createToken(String username, Set<Role> roles) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", getRoleNames(roles));

        Date now = new Date();
        Date validity = new Date(now.getTime() + expired);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Получаем токен из клиентского запроса
     */
    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer_")) {
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);

            if (claimsJws.getBody().getExpiration().before(new Date())) { //! простая проверка, истек ли токен на данный момент
                return false;
            }

            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthException("Jwt token was expired or invalid");
        }
    }

    private Set<String> getRoleNames(Set<Role> userRoles) {
        return userRoles.stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

}

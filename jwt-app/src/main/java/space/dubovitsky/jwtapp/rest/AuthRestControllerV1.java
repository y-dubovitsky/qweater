package space.dubovitsky.jwtapp.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.dubovitsky.jwtapp.dto.AuthRequestDto;
import space.dubovitsky.jwtapp.model.User;
import space.dubovitsky.jwtapp.security.jwt.JwtTokenProvider;
import space.dubovitsky.jwtapp.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthRestControllerV1 {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UserService userService;

    public AuthRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    public ResponseEntity login(@RequestBody AuthRequestDto requestDto) {
        try {

            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword())); //?

            User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("user with username: " + username + " not found");
            }

            String token = this.jwtTokenProvider.createToken(username, user.getRoles());

            Map<Object, Object> response = new HashMap<>(){{
                put("username", username);
                put("token", token);
            }};

            return ResponseEntity.ok(response);

        } catch (AuthenticationException a) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}

package net.javaguides.todo.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.todo.dto.UserRequest;
import net.javaguides.todo.dto.UserResponse;
import net.javaguides.todo.entity.User;
import net.javaguides.todo.repository.UserRepository;
import net.javaguides.todo.security.CustomUserDetailsService;
import net.javaguides.todo.service.AuthService;
import net.javaguides.todo.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepo;


    @Override
    public UserResponse login(UserRequest loginRequest) {

        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtUtil.generateToken(userDetails.getUsername());
        System.out.println(">>>>>>>>>  >"+accessToken);
//        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());

        User user = userRepo.findByEmail(userDetails.getUsername()).get();



        var userResponse = new UserResponse(accessToken, "refreshToken", user.getEmail());
        return userResponse;
    }


}

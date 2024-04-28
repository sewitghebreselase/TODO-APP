package net.javaguides.todo.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import net.javaguides.todo.dto.UserRequest;
import net.javaguides.todo.dto.UserResponse;
import net.javaguides.todo.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/uaa")
@RequiredArgsConstructor
//@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class UaaController {
    private final AuthService authService;
//    private final UserService userService;


    @PostMapping("/login")

    public ResponseEntity<UserResponse> login(@RequestBody UserRequest loginRequest) {


        UserResponse loginResponse = authService.login(loginRequest);

        return new ResponseEntity<UserResponse>(
                loginResponse, HttpStatus.OK);


    }

    @GetMapping("/signup")
    public String signUp() {
//        return new ResponseEntity<String>("Hello",HttpStatus.OK);
        return "hello";
    }


}

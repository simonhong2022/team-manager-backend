package org.mrs.teamapi.login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@RequestMapping(path = "/api/login")
public class UserController {
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private final UserService userService;

    public UserController(UserService service) { this.userService = service; }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> validateUser(@RequestBody LoginRequestDTO dto ){
        User user = userService.getUser(dto.username());
        if(user != null && encoder.matches(dto.password(), user.getPassword())) {
            return ResponseEntity.ok(new LoginResponseDTO(user.getUsername()));
        }
        return new ResponseEntity<>(new LoginResponseDTO(""), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping(path = "new")
    public ResponseEntity<LoginResponseDTO> createUser(@RequestBody LoginRequestDTO dto) {
        User user = userService.saveUser(dto.username(), encoder.encode(dto.password()));
        return ResponseEntity.ok(new LoginResponseDTO(user.getUsername()));
    }
}

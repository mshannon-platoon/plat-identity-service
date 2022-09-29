package ie.plat.identity.api.controller;

import ie.plat.identity.api.model.UserDTO;
import ie.plat.identity.domain.exception.UserAlreadyExistsException;
import ie.plat.identity.domain.model.User;
import ie.plat.identity.domain.service.UserService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class RegistrationController {

  private final UserService userService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
    try {
      User registeredUser = userService.registerNewAccount(userDTO);
      return ResponseEntity.ok().body(registeredUser);
    } catch (UserAlreadyExistsException ex) {
      log.error("exception thrown processing - /register -  request={} ex={}", userDTO, ex);
      return ResponseEntity.badRequest().build();
    }
  }
}

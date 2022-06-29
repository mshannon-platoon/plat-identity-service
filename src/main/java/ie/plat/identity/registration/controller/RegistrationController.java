package ie.plat.identity.registration.controller;

import ie.plat.identity.registration.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/register")
public class RegistrationController {

    @PostMapping
    public ResponseEntity<Void> registerUser(@Valid UserDTO userDTO){
        //
        return null;
    }
}

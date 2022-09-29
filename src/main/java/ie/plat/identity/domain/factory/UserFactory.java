package ie.plat.identity.domain.factory;

import ie.plat.identity.api.model.UserDTO;
import ie.plat.identity.domain.model.User;
import ie.plat.identity.domain.security.Role;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserFactory {

  public User from(UserDTO userDTO) {
    return User
        .builder()
        .username(userDTO.getUsername())
        .email(userDTO.getEmail())
        .password(userDTO.getPassword())
        .roles(Role.USER.name())
        .build();
  }
}

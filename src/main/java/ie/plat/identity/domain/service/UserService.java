package ie.plat.identity.domain.service;

import ie.plat.identity.api.model.UserDTO;
import ie.plat.identity.domain.db.UserRepository;
import ie.plat.identity.domain.exception.UserAlreadyExistsException;
import ie.plat.identity.domain.factory.UserFactory;
import ie.plat.identity.domain.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User registerNewAccount(UserDTO userDTO) {
    if (emailExists(userDTO.getEmail())) {
      throw new UserAlreadyExistsException(
          "Account already exists with email address: " + userDTO.getEmail());
    }

    return userRepository.save(UserFactory.from(userDTO));
  }

  private boolean emailExists(String email) {
    return userRepository.findByEmail(email) != null;
  }

}

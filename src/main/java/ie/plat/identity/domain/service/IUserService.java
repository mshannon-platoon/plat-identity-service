package ie.plat.identity.domain.service;

import ie.plat.identity.api.model.UserDTO;
import ie.plat.identity.domain.model.User;

public interface IUserService {

	User registerNewAccount(UserDTO userDTO);

}

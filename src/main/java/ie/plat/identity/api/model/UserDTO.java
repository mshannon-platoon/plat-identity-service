package ie.plat.identity.api.model;

import ie.plat.identity.api.validation.ValidEmail;
import ie.plat.identity.api.validation.ValidPassword;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ValidPassword
public class UserDTO {

	@NotNull
	@NotEmpty
	private String username;

	@NotNull
	@NotEmpty
	@ValidEmail
	private String email;

	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;

}

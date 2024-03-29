package ie.plat.identity.api.validation;


import ie.plat.identity.api.model.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {

	@Override
	public void initialize(ValidPassword constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		UserDTO user = (UserDTO) value;
		return user.getPassword().equals(user.getMatchingPassword());
	}
}

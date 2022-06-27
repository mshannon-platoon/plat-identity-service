package ie.plat.identity.registration.validation;

import ie.plat.identity.registration.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class PasswordValidatorTest {

    @Mock
    ConstraintValidatorContext context;

    @InjectMocks
    PasswordValidator passwordValidator;

    @Test
    void testIsValid() {
        assertTrue(passwordValidator.isValid(createUserDTO("password", "password"), context));
        assertTrue(passwordValidator.isValid(createUserDTO("PASSword", "PASSword"), context));
        assertTrue(passwordValidator.isValid(createUserDTO("PASSword ", "PASSword "), context));

        assertFalse(passwordValidator.isValid(createUserDTO("PASSword", "password"), context));
        assertFalse(passwordValidator.isValid(createUserDTO("Password ", "password"), context));
        assertFalse(passwordValidator.isValid(createUserDTO("Password123 ", "password123"), context));
    }

    private UserDTO createUserDTO(String password, String matchingPassword) {
        return UserDTO
                .builder()
                .password(password)
                .matchingPassword(matchingPassword)
                .build();
    }
}

package ie.plat.identity.api.validation;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EmailValidatorTest {

	@Mock
	ConstraintValidatorContext context;

	@InjectMocks
	EmailValidator emailValidator;

	@ParameterizedTest
	@ValueSource(strings = {
					"test@testgmail.com",
					"test-123@gmail.com",
					"test+3@gmail.com",
					"test124341@facemail.com"
	})
	void testIsValid_validVariations(String source) {
		assertTrue(emailValidator.isValid(source, context));
	}

	@ParameterizedTest
	@ValueSource(strings = {
					"testtestgmail.com",
					"test@gmail",
					"test$£@gmail.com",
					"test124341@facemail.123"
	})
	void testIsValid_inValidVariations(String source) {
		assertFalse(emailValidator.isValid(source, context));
	}
}

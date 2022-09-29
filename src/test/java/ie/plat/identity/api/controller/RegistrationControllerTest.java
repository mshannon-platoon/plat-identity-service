package ie.plat.identity.api.controller;

import ie.plat.identity.domain.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private UserService userService;

  @Test
  void testAbc() {
    //TODO: Left off here. MVC is working.
    //https://stackoverflow.com/questions/44287821/how-to-disable-flyway-in-a-certain-spring-profile/47837303#47837303
    // we have to disable flyway during these tests
  }

}

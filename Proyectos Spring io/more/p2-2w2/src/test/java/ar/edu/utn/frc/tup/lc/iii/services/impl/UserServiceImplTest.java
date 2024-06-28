package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.models.User;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void createUserTest() {
        // TODO(Completado) Testing
        User user = userService.createUser("Mart", "Vz", "test@email.com", "Password12");

        assertEquals("Mart", user.getName());
        assertEquals("test@email.com", user.getEmail());
        assertEquals("Vz", user.getLastName());

    }

    @Test
    void getUserByEmailTest() {
        // TODO(Completado Testing
        User user = userService.getUserByEmail("lm@hjm.com");

        assertEquals("lm@hjm.com", user.getEmail());
        assertEquals("Luca", user.getName());
        assertEquals("Morais", user.getLastName());
        assertEquals("password", user.getPassword());

    }

}
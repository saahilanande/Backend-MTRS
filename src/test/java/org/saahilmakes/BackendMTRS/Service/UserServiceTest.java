package org.saahilmakes.BackendMTRS.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
    private UsersRepo usersRepo;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(usersRepo);
    }

    @Test
    void canGetAllUser() {
        // When
        userService.GetAllUser();

        // Then
        verify(usersRepo).findAll();
    }

    @Test
    @Disabled
    void addNewUser() {
    }

    @Test
    void canDeleteUser() {
        //Given
        long id = 2;
        //When
        userService.DeleteUser(id);
        //Then
        verify(usersRepo).deleteById(id);

    }
}
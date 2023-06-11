package org.saahilmakes.BackendMTRS.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.saahilmakes.BackendMTRS.Model.UserModel;
import org.saahilmakes.BackendMTRS.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.authentication.AuthenticationManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class UserServiceTest {

    @Mock
    private UsersRepo usersRepo;

    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @BeforeEach
    void setUp() {
        userService = new UserService(usersRepo, authenticationManager, tokenService);
    }

    @Test
    void canGetAllUser() {
        // When
        userService.GetAllUser();

        // Then
        verify(usersRepo).findAll();
    }

    @Test
    void addNewUser() {
        //Given
        UserModel newUser = new UserModel();
        newUser.setEmail("test@test.com");
        newUser.setPhone(9999);
        newUser.setPassword("test");
        newUser.setRole("test");
        newUser.setUsername("test");

        //When
        userService.AddNewUser(newUser);

        //Then
        ArgumentCaptor<UserModel> userModelArgumentCaptor = ArgumentCaptor.forClass(UserModel.class);
        verify(usersRepo).save(userModelArgumentCaptor.capture());

        UserModel capturedUser = userModelArgumentCaptor.getValue();
        assertThat(capturedUser).isEqualTo(newUser);
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
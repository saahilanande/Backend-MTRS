//package org.saahilmakes.BackendMTRS.Repository;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.saahilmakes.BackendMTRS.Model.UserModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//@DataJpaTest
//class UsersRepoTest {
//
//    @Autowired
//    private UsersRepo usersRepo;
//
//    @AfterEach
//    void tearDown() {
//        usersRepo.deleteAll();
//    }
//
////    @Test
////    void itShouldCheckIfEmailExist() {
////
////        //Given
////        UserModel newUser = new UserModel();
////        newUser.setEmail("test@test.com");
////        newUser.setPhone(9999);
////        newUser.setPassword("test");
////        newUser.setRole("test");
////        newUser.setUsername("test");
////        usersRepo.save(newUser);
////        String emailToCheck = "test@test.com";
////
////        //When
////        Boolean expected = usersRepo.findEmail(emailToCheck);
////
////        //Then
////        assertThat(expected).isTrue();
////    }
////
////    @Test
////    void itShouldCheckIfNotEmailExist() {
////
////        //Given
////        UserModel newUser = new UserModel();
////        newUser.setEmail("test@test.com");
////        newUser.setPhone(9999);
////        newUser.setPassword("test");
////        newUser.setRole("test");
////        newUser.setUsername("test");
////        usersRepo.save(newUser);
////        String emailToCheck = "email@.com";
////
////        //When
////        Boolean expected = usersRepo.findEmail(emailToCheck);
////
////        //Then
////        assertThat(expected).isFalse();
////    }
////
////    @Test
////    void itShouldGetUserDetailsByEmail() {
////
////        //Given
////        UserModel newUser = new UserModel();
////        newUser.setEmail("test@test.com");
////        newUser.setPhone(9999);
////        newUser.setPassword("test");
////        newUser.setRole("test");
////        newUser.setUsername("test");
////        usersRepo.save(newUser);
////        String emailToCheck = "test@test.com";
////
////        //When
////        UserModel user = usersRepo.getUserDetailsbyEmail(emailToCheck);
////
////        //Then
////        assertThat(user).isEqualTo(newUser);
////    }
//}
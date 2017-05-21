package com.example.ratingapp.repository;

import com.example.ratingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email")
    List<User> findByUsernameAndMail(@Param("username") String username, @Param("email") String email);



//    @Query("select u from User u where u.firstname like %?1")
//    List<User> findByFirstnameEndsWith(String firstname);

//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);



}

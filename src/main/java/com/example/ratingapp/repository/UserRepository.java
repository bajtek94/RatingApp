package com.example.ratingapp.repository;

import com.example.ratingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    /////////////////////////
    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findListByUsername(@Param("username") String username);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    List<User> findByLastName(@Param("lastName") String lastName);
    ///////////////////////////

    @Query("SELECT u FROM User u WHERE u.name = :name AND u.lastName = :lastName")
    List<User> findByNameAndLastName(@Param("name") String name, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.lastName = :lastName")
    List<User> findByEmailAndLastName(@Param("email") String email, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.name = :name")
    List<User> findByEmailAndName(@Param("email") String email, @Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.lastName = :lastName")
    List<User> findByUsernameAndLastName(@Param("username") String username, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.name = :name")
    List<User> findByUsernameAndName(@Param("username") String username, @Param("name") String name);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email")
    List<User> findByUsernameAndEmail(@Param("username") String username, @Param("email") String email);
    ///////////////////////////

    @Query("SELECT u FROM User u WHERE u.email = :email AND u.name = :name AND  u.lastName = :lastName")
    List<User> findByEmailNameAndLastName(@Param("email") String email, @Param("name") String name, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.name = :name AND  u.lastName = :lastName")
    List<User> findByUsernameNameAndLastName(@Param("username") String username, @Param("name") String name, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email AND  u.lastName = :lastName")
    List<User> findByUsernameEmailAndLastName(@Param("username") String username, @Param("email") String email, @Param("lastName") String lastName);

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email AND  u.name = :name")
    List<User> findByUsernameEmailAndName(@Param("username") String username, @Param("email") String email, @Param("name") String name);
    ///////////////////////////

    @Query("SELECT u FROM User u WHERE u.username = :username AND u.email = :email AND u.name = :name AND  u.lastName = :lastName")
    List<User> findByEverything(@Param("username") String username, @Param("email") String email, @Param("name") String name, @Param("lastName") String lastName);


//    @Query("select u from User u where u.firstname like %?1")
//    List<User> findByFirstnameEndsWith(String firstname);

//    @Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
//    User findByLastnameOrFirstname(@Param("lastname") String lastname,
//                                   @Param("firstname") String firstname);



}

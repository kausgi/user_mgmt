package com.example.user_mgmt;
//

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    public UserService userService;
    public UserRepository userRepository ;
    public UserController(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
    }

    //creating new user
    @PostMapping("/users")
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        try{
            return new ResponseEntity<>(this.userService.createUser(user), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //fetching all users
    @GetMapping("/users")
    public ResponseEntity<List<User>> GetAllUsers(){
        try{
            return new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //fetching user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> GetUserById(@PathVariable("id") int id){
        try{
            return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //updating user by id
    @PutMapping("/users/{id}")
    public ResponseEntity<User> UpdateUser(@PathVariable("id") int id, @RequestBody User user){
        try{
            return new ResponseEntity<>(this.userService.updateUser(id,user), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //deleting user by id
    @DeleteMapping("/users/{id}")
    public ResponseEntity DeleteUser(@PathVariable("id") int id){
        try{
            this.userService.deleteUser(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //deleting all users
    @DeleteMapping("/users")
    public ResponseEntity DeleteAllUsers(){
        try{
            this.userService.deleteAllUser();
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}

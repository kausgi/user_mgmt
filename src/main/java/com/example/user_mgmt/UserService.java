package com.example.user_mgmt;
//

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //creating new user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //fetching all users
    public List<User> getAllUsers(){
        List<User> userList;
        userList = userRepository.findAll();
        return userList;
    }

    //fetching user by id
    public User getUserById(int id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    //updating user by id
    public User updateUser(int id,User user){
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.get().setName(user.getName());
        optionalUser.get().setAge(user.getAge());
        optionalUser.get().setAddress(user.getAddress());
        optionalUser.get().setLaptop(user.getLaptop());
        optionalUser.get().setPhone(user.getPhone());
        optionalUser.get().setSalary(user.getSalary());
        return userRepository.save(optionalUser.get());
    }

    //deleting user by id
    public void deleteUser(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent())
            userRepository.delete(user.get());

    }

    //deleting all users
    public void deleteAllUser(){
        userRepository.deleteAll();
    }


}


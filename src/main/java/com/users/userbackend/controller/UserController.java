package com.users.userbackend.controller;


import com.users.userbackend.exception.UserNotFoundException;
import com.users.userbackend.model.User;
import com.users.userbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/book" )
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }


    @GetMapping("/books")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

//
    @GetMapping("/book/{isbn}")
    User getUserById(@PathVariable String isbn){
        return userRepository.findByisbn(isbn);
    }

    @GetMapping("/books/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id)
                );
    }

//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable Long id){
//        return userRepository.findById(id)
//                .orElseThrow(()-> new UserNotFoundException(id));
//    }

    @PutMapping("/book/{id}")
    User updateUser(@RequestBody User newBook, @PathVariable Long id){
        return userRepository.findById(id)
                .map(book -> {
                    book.setAuthor(newBook.getAuthor());
                    book.setIsbn(newBook.getIsbn());
                    book.setTitle(newBook.getTitle());
                    book.setNotes(newBook.getNotes());
                    book.setTotalPageNo(newBook.getTotalPageNo());
                    book.setStatus((newBook.getStatus()));
                    return userRepository.save(book);
                })
                .orElseThrow(()-> new UserNotFoundException(id)
                );

    }
//        @DeleteMapping("/user/{id}")
//        String deleteuser(@PathVariable Long id){
//            userRepository.deleteById(id);
//            return "user gone";
//        }



    @DeleteMapping("/book/{isbn}")
    String deleteuser(@PathVariable String isbn){
//        if (!userRepository.existsById(id)) {
//            throw new UserNotFoundException(id);
//        }
        userRepository.deleteByIsbn(isbn);
        return "User with id has been deleted";
    }






}

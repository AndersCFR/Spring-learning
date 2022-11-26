package com.anders.spring_rest.controllers;

import com.anders.spring_rest.models.User;
import com.anders.spring_rest.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value="startWith", required = false) String startWith){
        return new ResponseEntity<List<User>>(userService.getUsers(startWith), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    @ApiOperation(value = "Returns user by username", response = User.class)
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "The record was found"),
            @ApiResponse(code = 404, message = "The record was not found"),
        }
    )
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        System.out.println(user);
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<User> updateUser(
            @PathVariable("username") String username,
            @RequestBody User user
    ){
        return new ResponseEntity<User>(userService.updateUser(user, username), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable("username") String username
    ){
        userService.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

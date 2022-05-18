package com.csi.controller;

import com.csi.model.User;
import com.csi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    UserService userServiceImpl;

    @PostMapping("/saveData")
    public ResponseEntity<String> saveUserData(@RequestBody User user){
        userServiceImpl.signUp(user);
        return ResponseEntity.ok("saved");
    }

    @PostMapping("/saveBulkData")
    public ResponseEntity<String> saveBulkData(@RequestBody List<User> users){
        userServiceImpl.saveBulOfData(users);
        return ResponseEntity.ok("more data saved");
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<User>> getAllData(){
        return ResponseEntity.ok(userServiceImpl.getAllData());
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<User> getByIdUser(@PathVariable int userId){
        return ResponseEntity.ok(userServiceImpl.getDataById(userId));

    }

    @DeleteMapping("/deleteByID/{userId}")
    public ResponseEntity<String> deletebyiD(@PathVariable int userId){
        userServiceImpl.deleteDataById(userId);
        return ResponseEntity.ok("deleted");

    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteall(){
        userServiceImpl.deleteAllData();
        return ResponseEntity.ok("deleted all data");

    }

    @GetMapping("/getByEmail/{userEmail}")
    public ResponseEntity<User> getByUserEmail(@PathVariable String userEmail){
        return ResponseEntity.ok(userServiceImpl.getDataByEmail(userEmail));

    }

    @GetMapping("/filterSalary/{salary}")
    public ResponseEntity<List<User>> filterSalary(@PathVariable double salary){
        return ResponseEntity.ok(userServiceImpl.filterData(salary));

    }

    @PutMapping("/updateByID/{userId}")

    public ResponseEntity<String> UpdateById(@PathVariable int userId,@RequestBody User user){
        userServiceImpl.updateData(userId,user);
        return ResponseEntity.ok("updated");
    }

    @GetMapping("/signIn/{email}/{pass}")
    public boolean signInUser(@PathVariable String email,@PathVariable String pass)
    {
        return userServiceImpl.signIn(email,pass);
    }
}

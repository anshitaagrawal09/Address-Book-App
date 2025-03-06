package com.example.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @GetMapping("/greet")
    public ResponseEntity<String> greet() {
        return new ResponseEntity<>("Welcome to Address Book App!", HttpStatus.OK);
    }
}

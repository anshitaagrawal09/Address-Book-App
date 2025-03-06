package com.example.addressbook.controller;

//UC2
import com.example.addressbook.model.AddressBook;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private final AddressBookRepository repository;

    public AddressBookController(AddressBookRepository repository) {
        this.repository = repository;
    }

    // GET all records
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(repository.findAll());
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        Optional<AddressBook> contact = repository.findById(id);
        return contact.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST - Create new record
    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBook contact) {
        return ResponseEntity.ok(repository.save(contact));
    }

    // PUT - Update by ID
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id, @RequestBody AddressBook newContact) {
        return repository.findById(id).map(contact -> {
            contact.setName(newContact.getName());
            contact.setAddress(newContact.getAddress());
            contact.setPhone(newContact.getPhone());
            return ResponseEntity.ok(repository.save(contact));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}




//UC1
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
////curl -X GET http://localhost:8080/addressbook/greet
//@RestController
//@RequestMapping("/addressbook")
//public class AddressBookController {
//
//    @GetMapping("/greet")
//    public ResponseEntity<String> greet() {
//        return new ResponseEntity<>("Welcome to Address Book App!", HttpStatus.OK);
//    }
//}

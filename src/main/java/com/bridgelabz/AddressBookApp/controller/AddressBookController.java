package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@RestController
public class AddressBookController {
    @GetMapping("/get")
    public ResponseEntity<String> getAllContact() {
        return new ResponseEntity<>("Get call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<String> getContactById(@PathVariable int Id) {
        return new ResponseEntity<>("Get call Success for id : " + Id, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addContact(@RequestBody AddressBookDto addressBookDto) {
        return new ResponseEntity<>("Created the Contact Data : " + addressBookDto, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<String> updateContact(@PathVariable int contactId) {
        return new ResponseEntity<>("Updated the Contact Data for : " + contactId , HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable int contactId) {
        return new ResponseEntity<>("Deleted Contact Data for : " + contactId, HttpStatus.OK);
    }
}

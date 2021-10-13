package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.dto.ResponseDto;
import com.bridgelabz.AddressBookApp.model.AddressBook;
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
    public ResponseEntity<ResponseDto> getAllContact() {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("Ashwith", 967619709,500044));
        ResponseDto responseDto = new ResponseDto("Get Call Success",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable int contactId) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("Abc",12345678,450055));
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id",addressBook);
        return  new ResponseEntity<ResponseDto>( responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addContact(@RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,contactDTO);
        ResponseDto responseDto = new ResponseDto("Added Address ",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable int contactId, @RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,contactDTO);
        ResponseDto responseDto = new ResponseDto("updated Address ",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDto> deleteContact(@PathVariable int contactId) {
        ResponseDto responseDto = new ResponseDto("Deleted Successfully ","deleted Address Id "+contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

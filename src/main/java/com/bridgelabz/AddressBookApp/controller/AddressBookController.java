package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.dto.ResponseDto;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is a controller class which controls all the requests from the
 * client side.
 *
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@RestController
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllContact() {
        List<AddressBook> addressBook = null;
        addressBook = addressBookService.getAddressBookData();
        ResponseDto responseDto = new ResponseDto("Get Call Success",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable int contactId) {
        AddressBook addressBook = null;
        addressBook = addressBookService.getAddressBookDataById(contactId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id",addressBook);
        return  new ResponseEntity<ResponseDto>( responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addContact(@RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = addressBookService.addAddress(contactDTO);
        ResponseDto responseDto = new ResponseDto("Added Address ",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateContact(@RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = addressBookService.UpdateAddress(contactDTO);
        ResponseDto responseDto = new ResponseDto("updated Address ",addressBook);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDto> deleteContact(@PathVariable int contactId) {
        addressBookService.deleteAddrees(contactId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully ","deleted Address Id "+contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

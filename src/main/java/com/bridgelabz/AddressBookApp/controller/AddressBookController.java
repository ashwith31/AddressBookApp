package com.bridgelabz.AddressBookApp.controller;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.dto.ResponseDto;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * This is a controller class which controls all the requests from the
 * client side.
 *
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@Slf4j
@RestController
public class AddressBookController {
    @Autowired
    AddressBookService addressBookService;

    /**
     * This is a get request mapping which allows the client to request all the
     * contacts present in AddressBook.
     *
     * @return ResponseEntity of type ResponseDto
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getAllContact() {
        List<AddressBook> addressBook = null;
        addressBook = addressBookService.getAddressBookData();
        ResponseDto responseDto = new ResponseDto("Get Call Success", addressBook);
        log.info("You have successfully got all the contacts");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * This is a get request mapping which allows the client to request the
     * contact with a specific id.
     *
     * @param contactId
     * @return ResponseEntity of type ResponseDto
     */
    @GetMapping("/get/{contactId}")
    public ResponseEntity<ResponseDto> getContactById(@PathVariable int contactId) {
        AddressBook addressBook = null;
        addressBook = addressBookService.getAddressBookDataById(contactId);
        ResponseDto responseDto = new ResponseDto("Get Call Success For Id", addressBook);
        log.info("You have successfully got the contacts with the id " + contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * This is a post request mapping which allows the client to add the
     * contact in the Address Book.
     *
     * @param contactDTO
     * @return ResponseEntity of type ResponseDto
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addContact(@Valid @RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = addressBookService.addAddress(contactDTO);
        ResponseDto responseDto = new ResponseDto("Added Address ", addressBook);
        log.info("You have successfully created the contact");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * This is a put request mapping which allows the client to update
     * the contact with a specific id.
     *
     * @param contactId
     * @param contactDTO
     * @return ResponseEntity of type ResponseDto
     */
    @PutMapping("/update/{contactId}")
    public ResponseEntity<ResponseDto> updateContact(@PathVariable(value = "contactId") int contactId,@Valid @RequestBody AddressBookDto contactDTO) {
        AddressBook addressBook = null;
        addressBook = addressBookService.UpdateAddress(contactId, contactDTO);
        ResponseDto responseDto = new ResponseDto("updated Address ", addressBook);
        log.info("You have successfully updated the the contact with id " + contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * This is a put request mapping which allows the client to delete
     * the contact with a specific id.
     *
     * @param contactId
     * @return ResponseEntity of type ResponseDto
     */
    @DeleteMapping("/delete/{contactId}")
    public ResponseEntity<ResponseDto> deleteContact(@PathVariable int contactId) {
        addressBookService.deleteAddrees(contactId);
        ResponseDto responseDto = new ResponseDto("Deleted Successfully ", "deleted Address Id " + contactId);
        log.info("You have successfully deleted the contact with id " + contactId);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}

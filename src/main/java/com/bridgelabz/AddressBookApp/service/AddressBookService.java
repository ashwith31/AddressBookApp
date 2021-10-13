package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Service Class which provides its service to the controller
 * class.
 *
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@Service
public class AddressBookService implements IAddressBookService {

    @Override
    public List<AddressBook> getAddressBookData() {
        List<AddressBook> addressBookList = new ArrayList<>();
        addressBookList.add(new AddressBook(1,new AddressBookDto("Ashwith",756904011,50044)));
        return addressBookList;
    }

    @Override
    public AddressBook getAddressBookDataById(int addrId) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,new AddressBookDto("Abc",78786667,400055));
        return addressBook;
    }

    @Override
    public AddressBook addAddress(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,addressBookDto);
        return addressBook;
    }

    @Override
    public AddressBook UpdateAddress(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(1,addressBookDto);
        return addressBook;
    }

    @Override
    public void deleteAddrees(int addrId) {

    }
}

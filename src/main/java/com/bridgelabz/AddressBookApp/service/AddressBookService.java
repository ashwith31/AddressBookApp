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
    private List<AddressBook> addressBookList = new ArrayList<>();

    @Override
    public List<AddressBook> getAddressBookData() {
        return addressBookList;
    }

    @Override
    public AddressBook getAddressBookDataById(int addrId) {
        return addressBookList.get(addrId-1);
    }

    @Override
    public AddressBook addAddress(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        addressBook = new AddressBook(addressBookList.size()+1,addressBookDto);
        addressBookList.add(addressBook);
        return addressBook;
    }

    @Override
    public AddressBook UpdateAddress(int contactId, AddressBookDto addressBookDto) {
        AddressBook addressBook = this.getAddressBookDataById(contactId);
        addressBook.setName(addressBookDto.getName());
        addressBook.setPhoneNumber(addressBookDto.getPhoneNumber());
        addressBookList.set(contactId-1,addressBook);
        return addressBook;
    }

    @Override
    public void deleteAddrees(int addrId) {
        addressBookList.remove(addrId-1);
    }
}

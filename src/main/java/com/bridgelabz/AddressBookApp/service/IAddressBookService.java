package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import java.util.List;
/**
  * @author Ashwith
  * @version 0.0.1
  * @since 13-10-2021
 */
public interface IAddressBookService {
    List<AddressBook> getAddressBookData();

    AddressBook getAddressBookDataById(int addrId);

    AddressBook addAddress(AddressBookDto addressBookDto);

    AddressBook UpdateAddress(AddressBookDto addressBookDto);

    void deleteAddrees(int addrId);
}

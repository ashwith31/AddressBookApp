package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.dto.ResponseContactDto;
import com.bridgelabz.AddressBookApp.exceptions.CustomException;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
     List<AddressBook> addressBookList = new ArrayList<>();

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AddressBook> getAddressBookData() {
        return  addressBookRepository.findAll();
    }

    @Override
    public AddressBook getAddressBookDataById(int id) {
        return addressBookRepository.findById(id)
                .orElseThrow(()-> new CustomException("Invalid Adderss"));
    }

    @Override
    public AddressBook addAddress(AddressBookDto addressBookDto) {
        AddressBook addressBook = null;
        modelMapper.map(addressBookDto, ResponseContactDto.class);
        addressBook = new AddressBook(addressBookDto);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public AddressBook updateAddress(int id, AddressBookDto addressBookDto) {
        AddressBook addressBook = this.getAddressBookDataById(id);
        modelMapper.map(addressBookDto, addressBook);
        return addressBookRepository.save(addressBook);
    }

    @Override
    public void deleteAddrees(int addrId) {
       AddressBook addressBook = this.getAddressBookDataById(addrId);
       addressBookRepository.delete(addressBook);
    }
}

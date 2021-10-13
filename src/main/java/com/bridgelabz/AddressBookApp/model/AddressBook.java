package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;

/**
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
public class AddressBook {
    private int id;
    private String name;
    private long number;
    private int pincode;

    public AddressBook(int id, AddressBookDto addressBookDto) {
        this.id = id;
        this.name = addressBookDto.getName();
        this.number = addressBookDto.getNumber();
        this.pincode = addressBookDto.getPincode();
    }
}

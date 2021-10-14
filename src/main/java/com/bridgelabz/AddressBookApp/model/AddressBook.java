package com.bridgelabz.AddressBookApp.model;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long phoneNumber;
    private int pincode;

    public AddressBook(int id, AddressBookDto addressBookDto) {
        this.id = id;
        this.name = addressBookDto.getName();
        this.phoneNumber = addressBookDto.getNumber();
        this.pincode = addressBookDto.getPincode();
    }
}

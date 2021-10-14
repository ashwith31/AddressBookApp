package com.bridgelabz.AddressBookApp.dto;

import lombok.Data;

/**
 * It is a DTO(Data Transfer Object) class which helps to transfer data to the
 * actual entity class.
 *
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
@Data
public class AddressBookDto {
    public String name;
    public long number;
    private int pincode;

    public AddressBookDto(String name, long number, int pincode) {
        this.name = name;
        this.number = number;
        this.pincode = pincode;
    }
}

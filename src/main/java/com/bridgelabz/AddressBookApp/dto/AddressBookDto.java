package com.bridgelabz.AddressBookApp.dto;

/**
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
public class AddressBookDto {
    public String name;
    public long number;
    private int pincode;

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public AddressBookDto(String name, long number, int pincode) {
        this.name = name;
        this.number = number;
        this.pincode = pincode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

}

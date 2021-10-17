package com.bridgelabz.AddressBookApp.dto;

import lombok.Data;

@Data
public class ResponseContactDto {
    private int id;
    private String name;
    private String phoneNumber;
    private String pincode;
}

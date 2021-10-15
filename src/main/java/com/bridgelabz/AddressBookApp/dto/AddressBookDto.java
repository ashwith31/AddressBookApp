package com.bridgelabz.AddressBookApp.dto;

import lombok.Data;

import javax.validation.constraints.*;

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
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Invalid name. Name should have atleast 3 letters.")
    public String name;
    @NotNull
    @Pattern(regexp = "^[1-9]{2}\\s[1-9][0-9]{9}$", message = "Invalid Phone Number. Eg: 91 9895612345")
    public String phoneNumber;
    @NotNull
    @Pattern(regexp = "^[0-9]{6}$", message = "Invalid pin-code")
    private String pincode;

}

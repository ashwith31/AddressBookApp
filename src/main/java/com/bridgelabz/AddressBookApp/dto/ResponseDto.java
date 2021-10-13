package com.bridgelabz.AddressBookApp.dto;

/**
 * @author Ashwith
 * @version 0.0.1
 * @since 13-10-2021
 */
public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}

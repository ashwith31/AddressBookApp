package com.bridgelabz.AddressBookApp.service;

import com.bridgelabz.AddressBookApp.dto.AddressBookDto;
import com.bridgelabz.AddressBookApp.dto.ResponseContactDto;
import com.bridgelabz.AddressBookApp.exceptions.CustomException;
import com.bridgelabz.AddressBookApp.model.AddressBook;
import com.bridgelabz.AddressBookApp.repository.AddressBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {
    @InjectMocks
    private AddressBookService adressBookService;

    @Mock
    private AddressBookRepository addressBookRepository;
    @Mock
    private ModelMapper modelMapper;

    @Test
    void whenGetAddressBookDataIsCalled_ShouldReturnAllContacts() {
        AddressBook addressBook = new AddressBook();
        addressBook.setName("Ashwith");
        ResponseContactDto responseDto = new ResponseContactDto();
        responseDto.setName("Ashwith");
        when(addressBookRepository.findAll()).thenReturn(List.of(addressBook));
        List<AddressBook> contacts = adressBookService.getAddressBookData();
        Assertions.assertEquals(1, contacts.size());
    }

    @Test
    void WhenUserEnteredSpecifiedContactId_ShouldReturnDataOfSpecifiedContactId() {
        AddressBook addressBook = new AddressBook();
        addressBook.setName("Ashwith");
        ResponseContactDto responseContactDto = new ResponseContactDto();
        responseContactDto.setName("Ashwith");
        when(addressBookRepository.findById(1)).thenReturn(Optional.of(addressBook));
        AddressBook actualContact = adressBookService.getAddressBookDataById(1);
        assertNotNull(actualContact);
    }

    @Test
    void whenGetAddressBookDataByIdIsCalled_shouldThrowException() {
        when(addressBookRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(CustomException.class, () -> adressBookService.getAddressBookDataById(1));
    }

    @Test
    void givenContactData_WhenaddContact_ShouldAddInToDatabase() {
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Ashwith");
        System.out.println(addressBookDto);

        AddressBook addressBook = new AddressBook();
        addressBook.setName(addressBookDto.getName());
        System.out.println(addressBook);

        when(addressBookRepository.save(addressBook)).thenReturn(addressBook);
        AddressBook actualAddressBookResponseDto = adressBookService.addAddress(addressBookDto);
        Assertions.assertEquals(addressBook.getName(), actualAddressBookResponseDto.getName());
        Mockito.verify(addressBookRepository, times(1)).save(addressBook);
    }

    @Test
    void givenContactData_WhenupdateContact_ShouldUpdateTheExsistingData(){
        int contactId=2;
        AddressBookDto addressBookDto = new AddressBookDto();
        addressBookDto.setName("Ashwith");
        AddressBook addressBook = new AddressBook();
        addressBook.setName(addressBookDto.getName());
        when(addressBookRepository.findById(2)).thenReturn(Optional.of(addressBook));
        when(addressBookRepository.save(addressBook)).thenReturn(addressBook);
        AddressBook addressBook1 = adressBookService.updateAddress(contactId, addressBookDto);
        Assertions.assertEquals(addressBook.getName(),addressBook1.getName());
        assertNotNull(addressBook1);
    }
}

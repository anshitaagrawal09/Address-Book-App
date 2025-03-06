package com.example.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {
    private String name;
    private String address;
    private String phone;

    public AddressBookDTO(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}

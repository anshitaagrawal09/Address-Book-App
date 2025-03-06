package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.addressbook.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {
}

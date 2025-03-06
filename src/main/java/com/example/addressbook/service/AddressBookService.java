package com.example.addressbook.service;

//UC5

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final List<AddressBook> addressBookList = new ArrayList<>();
    private long idCounter = 1L;

    public List<AddressBook> getAllContacts() {
        return new ArrayList<>(addressBookList);
    }

    public Optional<AddressBook> getContactById(Long id) {
        return addressBookList.stream().filter(contact -> contact.getId().equals(id)).findFirst();
    }

    public AddressBook addContact(AddressBookDTO dto) {
        AddressBook newContact = new AddressBook();
        newContact.setId(idCounter++);
        newContact.setName(dto.getName());
        newContact.setAddress(dto.getAddress());
        newContact.setPhone(dto.getPhone());
        addressBookList.add(newContact);
        return newContact;
    }

    public Optional<AddressBook> updateContact(Long id, AddressBookDTO dto) {
        return getContactById(id).map(contact -> {
            contact.setName(dto.getName());
            contact.setAddress(dto.getAddress());
            contact.setPhone(dto.getPhone());
            return contact;
        });
    }

    public void deleteContact(Long id) {
        addressBookList.removeIf(contact -> contact.getId().equals(id));
    }
}



//UC4
//import com.example.addressbook.dto.AddressBookDTO;
//import com.example.addressbook.model.AddressBook;
//import com.example.addressbook.repository.AddressBookRepository;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AddressBookService {
//
//    private final AddressBookRepository repository;
//
//    public AddressBookService(AddressBookRepository repository) {
//        this.repository = repository;
//    }
//
//    public List<AddressBook> getAllContacts() {
//        return repository.findAll();
//    }
//
//    public Optional<AddressBook> getContactById(Long id) {
//        return repository.findById(id);
//    }
//
//    public AddressBook addContact(AddressBookDTO dto) {
//        AddressBook newContact = new AddressBook(dto);
//        return repository.save(newContact);
//    }
//
//    public Optional<AddressBook> updateContact(Long id, AddressBookDTO dto) {
//        return repository.findById(id).map(contact -> {
//            contact.setName(dto.getName());
//            contact.setAddress(dto.getAddress());
//            contact.setPhone(dto.getPhone());
//            return repository.save(contact);
//        });
//    }
//
//    public void deleteContact(Long id) {
//        repository.deleteById(id);
//    }
//}

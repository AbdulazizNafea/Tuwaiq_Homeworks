package com.example.project5.Service;


import com.example.project5.ApiException.ApiException;
import com.example.project5.Model.Book;
import com.example.project5.Model.Customer;
import com.example.project5.Model.Store;
import com.example.project5.Repository.BookRepository;
import com.example.project5.Repository.CustomerRepository;
import com.example.project5.Repository.LocationRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServices {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;
    private  final BookRepository bookRepository;
    private final CustomerRepository customerRepository;


    public List<Store> getAll() {
        return storeRepository.findAll();
    }

    public void add(Store store) {
        storeRepository.save(store);
    }

    public void update(Store store, Integer id) {
        Store newStore = storeRepository.findStoreById(id);
        if (newStore == null) {
            throw new ApiException("Store ID not found");
        }
        newStore.setName(store.getName());
        storeRepository.save(newStore);


    }

    public void delete(Integer id) {
        Store store = storeRepository.findStoreById(id);
        if (store == null) {
            throw new ApiException("Store ID not found");
        }
        storeRepository.delete(store);
    }

    /////////////////////////////////////////////////////////
    //Add book to store
    public void addBookToStore(Integer book_id,Integer store_id) {
        Store store = storeRepository.findStoreById(store_id);
        Book book= bookRepository.findBookById(book_id);
        if (book == null ) {
            throw new ApiException("book not found");
        }else if (store == null){
            throw new ApiException("store not found");
        }

        book.setStore(store);
        bookRepository.save(book);
    }

    ////////////////////////////////////////////////////////////////////
    //Add customer to store
    public void addCustomerToStore(Integer customerId, Integer storeId){
        Store store = storeRepository.findStoreById(storeId);
        Customer customer = customerRepository.findCustomerById(customerId);
        if(store == null){
            throw new ApiException("store not found");
        }else if (customer == null){
            throw new ApiException("customer not found");
        }
        store.getCustomer().add(customer);
        customer.getStore().add(store);
        storeRepository.save(store);
        customerRepository.save(customer);
    }
    ////////////////////////////////////////////////////////////
    //Create endpoint that takes storeid and return all the books
    public List<Book> getAllBooks(Integer storeId){
        Store store = storeRepository.findStoreById(storeId);
        if (store == null) {
            throw new ApiException("store not found");
        }
        return store.getBook();
    }
    ////////////////////////////////////////////////////////////////
    //Create endpoint thar takes storeid and return all customers
    public List<Customer> getAllCustomers(Integer storeId){
        Store store = storeRepository.findStoreById(storeId);
        if (store == null) {
            throw new ApiException("store not found");
        }
        return store.getCustomer();
    }

}

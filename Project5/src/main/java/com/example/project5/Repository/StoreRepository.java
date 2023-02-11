package com.example.project5.Repository;

import com.example.project5.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Integer> {

    public Store findStoreById(Integer id);
}

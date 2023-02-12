package com.example.project5.Service;

import com.example.project5.ApiException.ApiException;
import com.example.project5.DTO.LocationDto;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import com.example.project5.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServices {

    private final LocationRepository locationRepository;
    private final StoreRepository storeRepository;


    public List<Location> getAll() {
        return locationRepository.findAll();
    }


    public void add(LocationDto LD) {
        Store store = storeRepository.findStoreById(LD.getStore_id());
        if (store == null) {
            throw new ApiException("Store id not found");
        }
        Location location = new Location(null, LD.getArea(), LD.getStreet(), store);
        locationRepository.save(location);
    }
    ////////////////////////////

    public void update(LocationDto ld) {
        Location newLocation = locationRepository.findLocationById(ld.getStore_id());
        if (newLocation == null) {
            throw new ApiException("location ID not found");
        }
        newLocation.setArea(ld.getArea());
        newLocation.setStreet(ld.getStreet());
        locationRepository.save(newLocation);
    }

    /////////////////////////////////////////////////////////
    public void delete(Integer id) {

        Location location = locationRepository.findByIdEquals(id);
        Store store = storeRepository.findStoreById(location.getStore().getId());
        if (location == null) {
            throw new ApiException("location ID not found");
        }
        store.setLocation(null);
        storeRepository.save(store);
        locationRepository.delete(location);
    }
}

package com.example.school_management_hw21.Services;

import com.example.school_management_hw21.DTO.AddressDTO;
import com.example.school_management_hw21.Model.Address;
import com.example.school_management_hw21.Model.Teacher;
import com.example.school_management_hw21.Repo.AddressRepository;
import com.example.school_management_hw21.Repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServices {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepo;


    public List<Address> getAll(){
        return addressRepository.findAll();
    }

    public boolean addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepo.findByIdEquals(addressDTO.getId());
        if(teacher==null){
            //throw  new ApiException("Id not found Teacher ");
            return false;
        }
        Address address1=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address1);
        return true;

    }




    public boolean updateAddress(AddressDTO ad){
        Address address = addressRepository.findByIdEquals(ad.getId());
        if (address == null) {
            return false;
        }

        address.setArea(ad.getArea());
        address.setBuildingNumber(ad.getBuildingNumber());
        address.setStreet(ad.getStreet());
        addressRepository.save(address);
        return true;
    }

    public boolean deleteAddress(Integer id){
        Address address = addressRepository.findByIdEquals(id);
        if (address == null) {
            return false;
        }
        addressRepository.delete(address);
        return true;
    }
}

package com.example.school_management_hw21.Services;


import com.example.school_management_hw21.ApiException.ApiException;
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
public class TeacherServices {

    private final TeacherRepository teacherRepo;
  //  private  final AddressRepository addressRepo;

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
    }

    public boolean updateTeacher(Teacher teacher , Integer id){
        Teacher teacher2 = teacherRepo.findByIdEquals(id);
        if (teacher2 == null) {
            return false;
        }
        teacher2.setName(teacher.getName());
        teacher2.setAge(teacher.getAge());
        teacher2.setEmail(teacher.getEmail());
        teacher2.setSalary(teacher.getSalary());
        teacherRepo.save(teacher2);
        return true;
    }


    public boolean deleteTeacher(Integer id){
        Teacher teacher2 = teacherRepo.findByIdEquals(id);
        if (teacher2 == null) {
            return false;
        }
        teacherRepo.delete(teacher2);
        return true;
    }

    //////////////////////////////////////////////////////////////////

//    public void addAddress (AddressDTO ad){
//        Teacher teacher= teacherRepo.findByIdEquals(ad.getTeacherId());
//        if (teacher == null) {
//            throw new ApiException("User id not found");
//        }
//       Address address = new Address(null,ad.getArea(),ad.getStreet(),ad.getBuildingNumber(),teacher);
//        addressRepo.save(address);
//      //  return true;
//    }
//
//    public void addAddress(AddressDTO addressDTO){
//        Teacher teacher=teacherRepo.findByIdEquals(addressDTO.getId());
//        if(teacher==null){
//            throw  new ApiException(" Id not found Teacher ");
//        }
//        Address address1=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
//        addressRepo.save(address1);
//
//    }

//
//
//    public boolean updateAddress(AddressDTO ad){
//        Address address = addressRepo.findByIdEquals(ad.getId());
//        if (address == null) {
//            return false;
//        }
//
//        address.setArea(ad.getArea());
//        address.setBuildingNumber(ad.getBuildingNumber());
//        address.setStreet(ad.getStreet());
//        addressRepo.save(address);
//        return true;
//    }
//
//    public boolean deleteAddress(Integer id){
//        Address address = addressRepo.findByIdEquals(id);
//        if (address == null) {
//            return false;
//        }
//        addressRepo.delete(address);
//        return true;
//    }
//
//    public List<Address> getAll(){
//        return addressRepo.findAll();
//    }
//
//    public boolean addAddress2(AddressDTO addressDTO){
//        Teacher teacher=teacherRepo.findByIdEquals(addressDTO.getId());
//        if(teacher==null){
//            //throw  new ApiException("Id not found Teacher ");
//            return false;
//        }
//        Address address1=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
//        addressRepo.save(address1);
//        return true;
//
//    }




}

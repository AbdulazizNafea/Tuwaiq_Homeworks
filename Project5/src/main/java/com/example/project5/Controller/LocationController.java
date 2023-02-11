package com.example.project5.Controller;

import com.example.project5.DTO.LocationDto;
import com.example.project5.Model.Location;
import com.example.project5.Service.LocationServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationServices locationServices;


    @GetMapping("/get")
    public ResponseEntity getAll() {
        return ResponseEntity.status(200).body(locationServices.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid LocationDto locationDTO) {
        locationServices.add(locationDTO);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid LocationDto ld) {
        locationServices.update(ld);
        return ResponseEntity.status(200).body("updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacherDetails(@PathVariable Integer id){
            locationServices.delete(id);
            return ResponseEntity.status(200).body("deleted");
    }
    //////////////////////////////////////////////////////////


}

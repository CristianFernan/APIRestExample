package org.example.apirestaurant.controllers;

import lombok.AllArgsConstructor;
import org.example.apirestaurant.DTOs.GeneralResponse;
import org.example.apirestaurant.DTOs.request.PlateDTORequest;
import org.example.apirestaurant.services.implementations.PlateServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/restaurant")
@AllArgsConstructor
public class PlateController {
    private final PlateServiceImpl plateService;

    @PostMapping("/plate/create")
    public ResponseEntity<GeneralResponse> createPlate(@RequestBody PlateDTORequest plate){
        plateService.createPlate(plate);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plate)
                .message("Plate has been created")
                .build());
    }

    @GetMapping("/plates")
    public ResponseEntity<GeneralResponse> findAllPlate(){
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plateService.getAllPlates())
                .message("All plates found")
                .build());
    }

    @GetMapping("/plate/{id}")
    public ResponseEntity<GeneralResponse> findPlateById(@PathVariable Long id){
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plateService.getPlateById(id))
                .message("Found Plate, id: " + id)
                .build());
    }

    @PutMapping("/plate/update/{id}")
    public ResponseEntity<GeneralResponse> updatePlate(@RequestBody PlateDTORequest plate,@PathVariable Long id){
        plateService.updatePlate(id, plate);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plate)
                .message("Plate "+ id +" was updated")
                .build());
    }

    @DeleteMapping("/plate/delete/{id}")
    public ResponseEntity<GeneralResponse> deletePlate(@PathVariable Long id){
        plateService.deletePlate(id);
        return ResponseEntity.ok(GeneralResponse.builder()
                .data(plateService.deletePlate(id))
                .message("Plate "+id+" was deleted")
                .build());
    }
}
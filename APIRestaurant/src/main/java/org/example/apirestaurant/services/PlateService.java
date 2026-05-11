package org.example.apirestaurant.services;

import org.example.apirestaurant.DTOs.request.PlateDTORequest;
import org.example.apirestaurant.entities.Plate;

import java.util.List;

public interface PlateService {
    void createPlate(PlateDTORequest plate);
    void updatePlate(Long id, PlateDTORequest plate);
    List<Plate> getAllPlates();
    Plate getPlateById(Long id);
    Plate deletePlate(Long id);


}

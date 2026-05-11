package org.example.apirestaurant.services.implementations;


import lombok.RequiredArgsConstructor;
import org.example.apirestaurant.DTOs.request.PlateDTORequest;
import org.example.apirestaurant.entities.Plate;
import org.example.apirestaurant.repositories.PlateRepository;
import org.example.apirestaurant.services.PlateService;
import org.example.apirestaurant.utils.PlateMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlateServiceImpl implements PlateService {
    private final PlateRepository plateRepository;

    @Override
    public void createPlate(PlateDTORequest plate) { plateRepository.save(PlateMapper.toEntity(plate)); }

    @Override
    public List<Plate> getAllPlates(){ return plateRepository.findAll(); }

    @Override
    public Plate getPlateById(Long id){ return plateRepository.getPlateById(id); }

    @Override
    public void updatePlate(Long id, PlateDTORequest plate){
        Plate existPlate = plateRepository.getPlateById(id);
        existPlate.setAvailable(plate.availability());
        existPlate.setName(plate.plate_name());
        existPlate.setDescription(plate.plate_description());
        existPlate.setPrice(plate.plate_price());
        plateRepository.save(existPlate);
    }

    @Override
    public Plate deletePlate(Long id){
        Plate existPlate = plateRepository.getPlateById(id);
        plateRepository.deleteById(id);
        return existPlate;
    }
}

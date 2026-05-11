package org.example.apirestaurant.utils;


import org.example.apirestaurant.DTOs.request.PlateDTORequest;
import org.example.apirestaurant.DTOs.response.PlateDTOResponse;
import org.example.apirestaurant.entities.Plate;

public class PlateMapper {

    public static Plate toEntity(PlateDTORequest plateDTORequest){
        return Plate.builder()
                .name(plateDTORequest.plate_name())
                .description(plateDTORequest.plate_description())
                .price(plateDTORequest.plate_price())
                .available(plateDTORequest.availability())
                .build();
    }

    public static PlateDTOResponse toResponse(Plate plate){
        return new PlateDTOResponse(
                plate.getName(),
                plate.getPrice()
        );
    }
}

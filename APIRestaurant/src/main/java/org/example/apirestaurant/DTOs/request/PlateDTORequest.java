package org.example.apirestaurant.DTOs.request;

import lombok.Builder;

@Builder
public record PlateDTORequest (
        String plate_name,
        String plate_description,
        Double plate_price,
        Boolean availability
) {
}


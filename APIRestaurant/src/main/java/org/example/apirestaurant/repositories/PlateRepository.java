package org.example.apirestaurant.repositories;

import org.example.apirestaurant.entities.Plate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlateRepository extends JpaRepository<Plate, Long> {
    Plate getPlateById(Long id);
}

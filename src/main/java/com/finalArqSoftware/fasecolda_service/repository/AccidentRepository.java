package com.finalArqSoftware.fasecolda_service.repository;

import com.finalArqSoftware.fasecolda_service.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findByVehiclePlate(String vehiclePlate);
}

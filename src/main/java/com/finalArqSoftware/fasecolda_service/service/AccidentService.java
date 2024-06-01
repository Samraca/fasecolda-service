package com.finalArqSoftware.fasecolda_service.service;

import com.finalArqSoftware.fasecolda_service.entity.Accident;
import com.finalArqSoftware.fasecolda_service.repository.AccidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentRepository accidentRepository;

    public List<Accident> findByPlate(String plate){
        return accidentRepository.findByVehiclePlate(plate);
    }

    public Accident saveAccident(Accident accident){
        return accidentRepository.save(accident);
    }
}

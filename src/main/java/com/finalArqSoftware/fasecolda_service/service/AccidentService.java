package com.finalArqSoftware.fasecolda_service.service;

import com.finalArqSoftware.fasecolda_service.entity.Accident;
import com.finalArqSoftware.fasecolda_service.repository.AccidentRepository;
import com.finalArqSoftware.fasecolda_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {
    @Autowired
    private AccidentRepository accidentRepository;

    public Response findByPlate(String plate){
        List<Accident> accidents =  accidentRepository.findByVehiclePlate(plate);
        Response response = new Response();
        int soloLatas = 0;
        int heridos = 0;
        int muertos  = 0;
        for (Accident accident : accidents){
            switch (accident.getSeverity()){
                case "solo latas":
                    soloLatas+=1;
                    break;
                case "heridos":
                    heridos+=1;
                    break;
                case "muertos":
                    muertos+=1;
                    break;
                default:
                    break;
            }
        }
        response.setHeridos(heridos);
        response.setMuertos(muertos);
        response.setSoloLatas(soloLatas);
        return response;
    }

    public Accident saveAccident(Accident accident){
        return accidentRepository.save(accident);
    }
}

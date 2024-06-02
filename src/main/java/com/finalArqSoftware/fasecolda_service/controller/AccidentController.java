package com.finalArqSoftware.fasecolda_service.controller;

import com.finalArqSoftware.fasecolda_service.entity.Accident;
import com.finalArqSoftware.fasecolda_service.response.Response;
import com.finalArqSoftware.fasecolda_service.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accidents")
public class AccidentController {
    @Autowired
    private AccidentService accidentService;

    @GetMapping("/{plate}")
    public ResponseEntity<Response> getAccidentsByPlate(@PathVariable String plate) {
        return ResponseEntity.ok(accidentService.findByPlate(plate));
    }

    @PostMapping
    public ResponseEntity<Accident> createAccident(@RequestBody Accident accident){
        Accident savedAccident = accidentService.saveAccident(accident);
        return ResponseEntity.ok(savedAccident);
    }
}

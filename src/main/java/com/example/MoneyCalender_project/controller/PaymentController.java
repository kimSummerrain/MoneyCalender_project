package com.example.MoneyCalender_project.controller;

import com.example.MoneyCalender_project.model.PaymentEntity;
import com.example.MoneyCalender_project.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PaymentController {
    @Autowired
    private PlaceService placeService;

    @PostMapping
    public PaymentEntity addPlace(
            @RequestParam String name,
            @RequestParam double price) {
        return placeService.savePlace(name, price);
    }

    @GetMapping("/all")
    public List<PaymentEntity> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}



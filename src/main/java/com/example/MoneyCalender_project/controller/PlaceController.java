package com.example.MoneyCalender_project.controller;

import com.example.MoneyCalender_project.model.PaymentEntity;
import com.example.MoneyCalender_project.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @PostMapping("/add")
    public PaymentEntity addPlace(PaymentEntity paymentEntity) {
        return placeService.savePlace(paymentEntity.getPlaceName(), paymentEntity.getPrice());
    }

    @GetMapping("/all")
    public List<PaymentEntity> getAllPayments() {
        return placeService.getAllPlaces();
    }
}



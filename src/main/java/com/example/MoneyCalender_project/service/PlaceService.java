package com.example.MoneyCalender_project.service;


import com.example.MoneyCalender_project.model.PaymentEntity;
import com.example.MoneyCalender_project.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PlaceService {

    @Autowired
    private GooglePlacesService googlePlacesService;

    @Autowired
    private PlaceRepository placeRepository;
    
    public PaymentEntity savePlace(String placeName, double price){
        String category = googlePlacesService.getPlaceCategory(placeName);
        
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPlaceName(placeName);
        paymentEntity.setCategory(category !=null ? category : "Unknown");
        paymentEntity.setPrice(price);


        return placeRepository.save(paymentEntity);
    }

    public List<PaymentEntity> getAllPlaces(){
        return placeRepository.findAll();
    }
}

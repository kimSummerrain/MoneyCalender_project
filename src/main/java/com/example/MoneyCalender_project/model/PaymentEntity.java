package com.example.MoneyCalender_project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String placeName;
    private String category;
    private double price;

    @PrePersist
    protected void onCreate() {
        this.dateTime = LocalDateTime.now();
    }
}
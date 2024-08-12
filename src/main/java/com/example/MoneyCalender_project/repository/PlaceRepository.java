package com.example.MoneyCalender_project.repository;

import com.example.MoneyCalender_project.model.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<PaymentEntity,Long> {
}

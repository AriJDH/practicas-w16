package com.compositekey.purchase.service;

import com.compositekey.purchase.DTO.PurchaseDto;
import com.compositekey.purchase.entity.PurchaseId;

import java.time.LocalDate;

public interface IPurchaseService {

    PurchaseDto create(PurchaseDto purchaseCreateDTO);

    PurchaseDto getById(Integer clientId, String datePurchase);
}

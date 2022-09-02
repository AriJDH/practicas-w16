package com.compositekey.purchase.service;

import com.compositekey.purchase.DTO.PurchaseDto;
import com.compositekey.purchase.dao.IPurchaseDao;
import com.compositekey.purchase.entity.Purchase;
import com.compositekey.purchase.entity.PurchaseId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PurchaseService implements IPurchaseService {

    @Autowired
    IPurchaseDao purchaseDao;

    private final ModelMapper modelMapper;

    public PurchaseService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public PurchaseDto create(PurchaseDto purchaseCreateDTO) {

        Purchase result = purchaseDao.save(modelMapper.map(purchaseCreateDTO, Purchase.class));

        return modelMapper.map(result, PurchaseDto.class);
    }

    @Override
    public PurchaseDto getById(Integer clientId, String datePurchase) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(datePurchase, dtf);

        PurchaseId purchaseId = new PurchaseId(clientId, date);

        Purchase result = purchaseDao.getReferenceById(purchaseId);

        return modelMapper.map(result, PurchaseDto.class);
    }

}

package com.spring.concesionaria.service;

import com.spring.concesionaria.DTO.VehicleDTO;
import com.spring.concesionaria.repository.IVehicleDAO;
import com.spring.concesionaria.repository.VehicleDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService{

    @Autowired
    IVehicleDAO iVehicleDAO;

    @Override
    public boolean add(VehicleDTO v) {
        return iVehicleDAO.add(v);
    }

    @Override
    public List<VehicleDTO> findAll() {
        return iVehicleDAO.findAll();
    }

    @Override
    public VehicleDTO findById(String model) {
        return iVehicleDAO.findById(model);
    }

    @Override
    public List<VehicleDTO> findByDate(LocalDate since, LocalDate to) {
        return iVehicleDAO.findByDate(since, to);
    }

    @Override
    public List<VehicleDTO> findByPrice(Double since, Double to) {
        return iVehicleDAO.finByPrice(since, to);
    }


}

package com.bootcamp.dealership.controller;

import com.bootcamp.dealership.dto.request.VehicleReqDTO;
import com.bootcamp.dealership.dto.response.VehicleResDTO;
import com.bootcamp.dealership.service.IService;
import com.bootcamp.dealership.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {
    private IService<VehicleResDTO, VehicleReqDTO> vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("")
    public ResponseEntity<List<VehicleResDTO>> findAll(@RequestParam Map<String, String> filters){
        return new ResponseEntity<>(this.vehicleService.findAll(filters), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleResDTO>> findByPrices(@RequestParam Map<String, String> filters){
        return new ResponseEntity<>(this.vehicleService.findByPrices(filters), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleResDTO>> findByDates(@RequestParam Map<String, String> filters){
        return new ResponseEntity<>(this.vehicleService.findByDates(filters), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(this.vehicleService.findById(id), HttpStatus.OK);
        }catch (NullPointerException e){
            return new ResponseEntity<>(
                    "No se logró encontrar el vehículo que está buscando",
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping("")
    public ResponseEntity<VehicleResDTO> save(@RequestBody VehicleReqDTO vehicleReqDTO){
        return new ResponseEntity<>(this.vehicleService.save(vehicleReqDTO), HttpStatus.CREATED);
    }

}

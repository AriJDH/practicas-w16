package com.bootcamp.dealership.repository;

import com.bootcamp.dealership.entity.Vehicle;
import com.bootcamp.dealership.util.Util;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository implements IRepository<Vehicle> {
    private List<Vehicle> vehicles;
    private Long id;

    public VehicleRepository() {
        this.id = 1L;
        this.vehicles = new ArrayList<>();
    }

    private List<Vehicle> filterVehicles(Map<String, String> filters) {
        return this.vehicles.stream()
                .filter(vehicle -> filters.keySet().stream()
                        .allMatch(attribute -> {
                            if (attribute.equals("brand"))
                                return vehicle.getBrand().equalsIgnoreCase(filters.get(attribute));
                            if (attribute.equals("model"))
                                return vehicle.getModel().equalsIgnoreCase(filters.get(attribute));
                            if (attribute.equals("to"))
                                return vehicle.getManufacturingDate().compareTo(Util.parseDate(filters.get(attribute))) < 1;
                            if (attribute.equals("since"))
                                return vehicle.getManufacturingDate().compareTo(Util.parseDate(filters.get(attribute))) > -1;
                            return false;
                        })
                )
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findAll(Map<String, String> filter) {
        if (filter.isEmpty()) return this.vehicles;
        return this.filterVehicles(filter);
    }

    @Override
    public Vehicle findById(Long id) {
        return this.vehicles.stream()
                .filter(vehicle -> vehicle.getId() == id)
                .findFirst()
                .get();
    }

    public List<Vehicle> findByPrices(Map<String, String> prices) {
        return this.vehicles.stream()
                .filter(vehicle -> prices.keySet().stream()
                        .allMatch(attibute -> {
                            if (attibute.equals("to"))
                                return vehicle.getPrice().compareTo(Long.valueOf(prices.get(attibute))) < 1;
                            if (attibute.equals("since"))
                                return vehicle.getPrice().compareTo(Long.valueOf(prices.get(attibute))) > -1;
                            return false;
                        })
                )
                .collect(Collectors.toList());
    }

    public List<Vehicle> findByDates(Map<String, String> prices) {
        return this.vehicles.stream()
                .filter(vehicle -> prices.keySet().stream()
                        .allMatch(attibute -> {
                            if (attibute.equals("to"))
                                return vehicle.getManufacturingDate().compareTo(Util.parseDate(prices.get(attibute))) < 1;
                            if (attibute.equals("since"))
                                return vehicle.getManufacturingDate().compareTo(Util.parseDate(prices.get(attibute))) > -1;
                            return false;
                        })
                )
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicle.setId(this.id++);
        this.vehicles.add(vehicle);
        return vehicle;
    }
}

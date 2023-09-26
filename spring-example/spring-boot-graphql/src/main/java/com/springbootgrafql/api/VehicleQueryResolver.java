package com.springbootgrafql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.springbootgrafql.entity.Vehicle;
import com.springbootgrafql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleQueryResolver implements GraphQLQueryResolver {
    private final VehicleRepository vehicleRepository;

    public VehicleQueryResolver(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Iterable<Vehicle> findVehicleByType(String type) {
        return vehicleRepository.getByTypeLike(type);
    }
    public Optional<Vehicle> findVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }
    public Iterable<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }
}

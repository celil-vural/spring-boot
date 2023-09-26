package com.springbootgrafql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.springbootgrafql.entity.Vehicle;
import com.springbootgrafql.entity.dto.VehicleDto;
import com.springbootgrafql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {
    private final VehicleRepository vehicleRepository;
    public Vehicle createVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = dtoToEntity(vehicleDto);
        return vehicleRepository.save(vehicle);
    }
    private Vehicle dtoToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDto.getType());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        return vehicle;
    }
}

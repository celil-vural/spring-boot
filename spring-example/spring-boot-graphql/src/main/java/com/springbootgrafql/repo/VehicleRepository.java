package com.springbootgrafql.repo;

import com.springbootgrafql.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Iterable<Vehicle> getByTypeLike(String type);


}

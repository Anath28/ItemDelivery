package com.Anath.ItemDelivery.repositories;

import com.Anath.ItemDelivery.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT status FROM Vehicle vehicle WHERE vehicle.status='IDLE'")
    List<Vehicle> getVehicleStatus();

}

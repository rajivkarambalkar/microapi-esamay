package com.esamay.repository;

import com.esamay.entity.GeofenceLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeoFenceLocationRepository extends JpaRepository<GeofenceLocation, String> {
}

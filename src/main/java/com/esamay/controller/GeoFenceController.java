package com.esamay.controller;

import com.esamay.domain.GeofenceLocation;
import com.esamay.service.geofence.GeoFenceServiceBoundary;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geofence")
public class GeoFenceController {

    private final GeoFenceServiceBoundary geoFenceServiceServiceApp;

    public GeoFenceController(GeoFenceServiceBoundary geoFenceServiceServiceApp) {
        this.geoFenceServiceServiceApp = geoFenceServiceServiceApp;
    }

    @GetMapping("/{geofenceId}")
    public GeofenceLocation getGeoFenceLocation(@PathVariable(name = "geofenceId") String geofenceId) {
        return geoFenceServiceServiceApp.getGeofenceLocation(geofenceId);
    }

    @GetMapping("/all")
    public List<GeofenceLocation> getGeoFenceLocations() {
        return geoFenceServiceServiceApp.getGeofenceLocations();
    }

    @PostMapping
    public GeofenceLocation addGeoFenceLocation(@RequestBody GeofenceLocation geofenceLocation) {
        return geoFenceServiceServiceApp.saveGeofenceLocation(geofenceLocation);
    }

    @PutMapping
    public GeofenceLocation updateGeoFenceLocation(@RequestBody GeofenceLocation geofenceLocation) {
        return geoFenceServiceServiceApp.updateGeofenceLocation(geofenceLocation);
    }

}

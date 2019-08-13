package com.esamay.service.geofence;

import com.esamay.domain.GeofenceLocation;
import com.esamay.repository.GeoFenceLocationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeoFenceServiceApp implements GeoFenceServiceBoundary {

    private final GeoFenceLocationRepository geoFenceLocationRepository;

    @Autowired
    public GeoFenceServiceApp(GeoFenceLocationRepository geoFenceLocationRepository) {
        this.geoFenceLocationRepository = geoFenceLocationRepository;
    }

    @Override
    public GeofenceLocation saveGeofenceLocation(GeofenceLocation geofenceLocation) {
                return mapEntitytoGeofenceLocation(geoFenceLocationRepository.saveAndFlush(mapGeofenceLocationToEntity(geofenceLocation)));
    }

    @Override
    public GeofenceLocation updateGeofenceLocation(GeofenceLocation geofenceLocation) {
        return mapEntitytoGeofenceLocation(geoFenceLocationRepository.saveAndFlush(mapGeofenceLocationToEntity(geofenceLocation)));
    }

    @Override
    public GeofenceLocation getGeofenceLocation(String geofenceLocationId) {
        return mapEntitytoGeofenceLocation(geoFenceLocationRepository.getOne(geofenceLocationId));
    }

    @Override
    public List<GeofenceLocation> getGeofenceLocations() {
        return mapGeofenceLocations(geoFenceLocationRepository.findAll());
    }


    private com.esamay.entity.GeofenceLocation mapGeofenceLocationToEntity(GeofenceLocation geofenceLocation) {
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<com.esamay.entity.GeofenceLocation>() {
        }.getType();
        return mapper.map(geofenceLocation, type);
    }
    private GeofenceLocation mapEntitytoGeofenceLocation(com.esamay.entity.GeofenceLocation geofenceLocation) {
        if (geofenceLocation == null) {
            return null;
        }
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<GeofenceLocation>() {
        }.getType();
        return mapper.map(geofenceLocation, type);
    }

    private List<GeofenceLocation> mapGeofenceLocations(List<com.esamay.entity.GeofenceLocation> geofenceLocations) {
        ModelMapper mapper = new ModelMapper();
        Type listType = new TypeToken<ArrayList<GeofenceLocation>>() {
        }.getType();
        return mapper.map(geofenceLocations, listType);
    }
}

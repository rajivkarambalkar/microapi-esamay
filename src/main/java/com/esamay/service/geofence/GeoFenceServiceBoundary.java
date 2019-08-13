package com.esamay.service.geofence;

import com.esamay.domain.GeofenceLocation;

import java.util.List;

public interface GeoFenceServiceBoundary {
    GeofenceLocation saveGeofenceLocation(GeofenceLocation GeofenceLocation);
    GeofenceLocation updateGeofenceLocation(GeofenceLocation GeofenceLocation);
    GeofenceLocation getGeofenceLocation(String GeofenceLocationId);
    List<GeofenceLocation> getGeofenceLocations();
}

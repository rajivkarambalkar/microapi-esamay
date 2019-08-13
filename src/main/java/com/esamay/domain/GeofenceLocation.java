package com.esamay.domain;

import lombok.Data;

@Data
public class GeofenceLocation {
    private String geofenceId;
    private String latitude;
    private String longitude;
    private String locationName;
}

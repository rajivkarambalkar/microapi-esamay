package com.esamay.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class TimeSheet {
    private String timeSheetId;
    private String userId;
    private Timestamp timestamp;
    private String activity;
    private String day;
}

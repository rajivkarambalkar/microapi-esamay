package com.esamay.service;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TimeSheetAppTest {

    @org.junit.jupiter.api.Test
    void saveTimeSheet() {
    }

    @org.junit.jupiter.api.Test
    void updateTimeSheet() {

        Date date= new Date();
        long time = date. getTime();
        Timestamp timestamp = new Timestamp(time);
        System.out.println(timestamp.toLocalDateTime().getDayOfWeek());
    }

    @org.junit.jupiter.api.Test
    void getTimeSheet() {
    }

    @org.junit.jupiter.api.Test
    void getTimeSheets() {
    }

    @org.junit.jupiter.api.Test
    void getTimeSheetsByUserId() {
    }
}
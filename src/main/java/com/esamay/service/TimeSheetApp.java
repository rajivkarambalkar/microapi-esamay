package com.esamay.service;

import com.esamay.domain.TimeSheet;
import com.esamay.repository.TimeSheetRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSheetApp implements TimeSheetBoundary {

    private final TimeSheetRepository timeSheetRepository;

    @Autowired
    public TimeSheetApp(TimeSheetRepository timeSheetRepository) {
        this.timeSheetRepository = timeSheetRepository;
    }

    @Override
    public TimeSheet saveTimeSheet(TimeSheet timeSheet) {
        timeSheet.setTimestamp(new Timestamp(System.currentTimeMillis()));
        timeSheet.setDay(timeSheet.getTimestamp().toLocalDateTime().getDayOfWeek().toString());
        return mapEntitytoTimeSheet(timeSheetRepository.saveAndFlush(mapTimeSheettoEntity(timeSheet)));
    }

    @Override
    public TimeSheet updateTimeSheet(TimeSheet timeSheet) {
        return mapEntitytoTimeSheet(timeSheetRepository.saveAndFlush(mapTimeSheettoEntity(timeSheet)));
    }

    @Override
    public TimeSheet getTimeSheet(String timeSheetId) {
        return mapEntitytoTimeSheet(timeSheetRepository.getOne(timeSheetId));
    }

    @Override
    public List<TimeSheet> getTimeSheets() {
        return mapTimeSheets(timeSheetRepository.findAll());
    }

    @Override
    public List<TimeSheet> getTimeSheetsByUserId(String userId) {
        return mapTimeSheets(timeSheetRepository.findByUserId(userId));
    }


    private com.esamay.entity.TimeSheet mapTimeSheettoEntity(TimeSheet timeSheet) {
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<com.esamay.entity.TimeSheet>() {
        }.getType();
        return mapper.map(timeSheet, type);
    }

    private TimeSheet mapEntitytoTimeSheet(com.esamay.entity.TimeSheet timeSheet) {
        if (timeSheet == null) {
            return null;
        }
        ModelMapper mapper = new ModelMapper();
        Type type = new TypeToken<TimeSheet>() {
        }.getType();
        return mapper.map(timeSheet, type);
    }

    private List<TimeSheet> mapTimeSheets(List<com.esamay.entity.TimeSheet> timeSheets) {
        ModelMapper mapper = new ModelMapper();
        Type listType = new TypeToken<ArrayList<TimeSheet>>() {
        }.getType();
        return mapper.map(timeSheets, listType);
    }
}

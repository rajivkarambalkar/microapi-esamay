package com.esamay.controller;

import com.esamay.domain.TimeSheet;
import com.esamay.service.TimeSheetBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimeSheetController {

    private final TimeSheetBoundary timeSheetApp;

    @Autowired
    public TimeSheetController(TimeSheetBoundary timeSheetApp) {
        this.timeSheetApp = timeSheetApp;
    }

    @GetMapping("/{timeSheetId}")
    public TimeSheet getTimeSheet(@PathVariable(name = "timeSheetId") String timeSheetId) {
        return timeSheetApp.getTimeSheet(timeSheetId);
    }

    @GetMapping("/all")
    public List<TimeSheet> getTimeSheets() {
        return timeSheetApp.getTimeSheets();
    }

    @GetMapping("/all/{userId}")
    public List<TimeSheet> getTimeSheetsByUser(@PathVariable(name = "userId") String userId) {
        return timeSheetApp.getTimeSheetsByUserId(userId);
    }

    @PostMapping
    public TimeSheet addTimeSheet(@RequestBody TimeSheet timeSheet) {
        return timeSheetApp.saveTimeSheet(timeSheet);
    }

    @PutMapping
    public TimeSheet updateTimeSheet(@RequestBody TimeSheet timeSheet) {
        return timeSheetApp.updateTimeSheet(timeSheet);
    }

}

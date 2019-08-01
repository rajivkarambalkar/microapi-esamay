package com.esamay.service;


import com.esamay.domain.TimeSheet;

import java.util.List;

public interface TimeSheetBoundary {
    TimeSheet saveTimeSheet(TimeSheet timeSheet);
    TimeSheet updateTimeSheet(TimeSheet timeSheet);
    TimeSheet getTimeSheet(String timeSheetId);
    List<TimeSheet> getTimeSheets();

    List<TimeSheet> getTimeSheetsByUserId(String userId);
}

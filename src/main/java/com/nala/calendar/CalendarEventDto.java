package com.nala.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarEventDto {
    private String id;
    private String title;
    private CalendarEventType CalendarEventType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

package com.nala.calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class CalendarEvent {
    @Id
    private String id;
    private String title;
    private CalendarEventType calendarEventType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

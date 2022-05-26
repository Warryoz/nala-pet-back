package com.nala.calendar;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/calendar-events")
@AllArgsConstructor
public class CalendarEventController {

    private final CalendarEventService calendarEventService;

    @GetMapping
    public List<CalendarEventDto> fetchAllCalendarEvents(){
        return calendarEventService.getAllCalendarEvents();
    }

    @GetMapping("/{calendarEventId}")
    public ResponseEntity<CalendarEventDto> fetchCalendarEventIdById(
            @PathVariable(value = "calendarEventId") String calendarEventId){
        return new ResponseEntity<>
                (calendarEventService.getCalendarEventById(calendarEventId),
                HttpStatus.OK); }

    @PostMapping
    public ResponseEntity<CalendarEventDto> createCalendarEventId(@RequestBody CalendarEventDto calendarEventDto){
        return new ResponseEntity<>(calendarEventService.createCalendarEvent(calendarEventDto), HttpStatus.CREATED);
    }

    @PutMapping("/{calendarEventId}")
    public ResponseEntity<CalendarEventDto> updateCalendarEventId(
            @PathVariable(value = "calendarEventId") String calendarEventId,
            @RequestBody CalendarEventDto calendarEventDto){
        return new ResponseEntity<>
                (calendarEventService.updateCalendarEvent(calendarEventId, calendarEventDto),
                HttpStatus.OK);
    }

    @DeleteMapping("/{calendarEventId}")
    public String deleteCalendarEvent(@PathVariable(value = "calendarEventId") String calendarEventId){
        return calendarEventService.deleteCalendarEvent(calendarEventId);
    }
}

package com.nala.calendar;

import com.nala.shared.config.security.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CalendarEventService {
    private final CalendarEventRepository calendarEventRepository;
    private final ModelMapper mapper;

    List<CalendarEventDto> getAllCalendarEvents(){
        return calendarEventRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    CalendarEventDto getCalendarEventById(String calendarEventId) {
        CalendarEvent calendarEvent = calendarEventRepository.findById(calendarEventId)
                .orElseThrow(()-> new ResourceNotFoundException("Calendar event", "id", calendarEventId));
        return mapToDto(calendarEvent);
    }

    CalendarEventDto createCalendarEvent(CalendarEventDto calendarEventDto) {
        CalendarEvent calendarEvent = mapToEntity(calendarEventDto);
        CalendarEvent newCalendarEventEvent = calendarEventRepository.save(calendarEvent);
        return mapToDto(newCalendarEventEvent);
    }

    CalendarEventDto updateCalendarEvent(String calendarEventId, CalendarEventDto calendarEventDto) {
        CalendarEvent calendarEvent = calendarEventRepository.findById(calendarEventId)
                .orElseThrow(()-> new ResourceNotFoundException("Calendar event", "id", calendarEventId));

        calendarEventRepository.save(calendarEvent);
        return mapToDto(calendarEvent);
    }

    String deleteCalendarEvent(String calendarEventId){
        CalendarEvent calendarEvent = calendarEventRepository.findById(calendarEventId)
                .orElseThrow(()-> new ResourceNotFoundException("Calendar event", "id", calendarEventId));
        calendarEventRepository.delete(calendarEvent);
        return "Calendar event successfully removed";
    }

    CalendarEventDto mapToDto(CalendarEvent calendarEvent){
        return mapper.map(calendarEvent, CalendarEventDto.class);
    }

    CalendarEvent mapToEntity(CalendarEventDto calendarEventDto){
        return mapper.map(calendarEventDto, CalendarEvent.class);
    }
}

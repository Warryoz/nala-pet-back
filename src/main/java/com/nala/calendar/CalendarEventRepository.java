package com.nala.calendar;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CalendarEventRepository extends MongoRepository<CalendarEvent, String> {
}

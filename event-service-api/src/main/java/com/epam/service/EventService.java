package com.epam.service;

import com.epam.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event);
    Event getEvent(long eventId);
    void deleteEvent(long eventId);
    List<Event> getAllEvents();
    List<Event> getAllEventsByTitle(String title);
}

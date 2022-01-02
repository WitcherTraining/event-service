package com.epam.webcomponent.controller;

import com.epam.model.Event;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.epam.service.EventService;

import java.util.List;

@Api("This is an example description of Event API")
@RestController
@RequestMapping(EventServiceController.BASE_URL)
public class EventServiceController {

    public static final String BASE_URL = "/api/v1/events";

    private final EventService eventService;

    public EventServiceController(EventService eventService) {
        this.eventService = eventService;
    }

    @ApiOperation(value = "This will get a list of events.", notes = "These are some notes about the API.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @ApiOperation(value = "This will get one event by ID.", tags = {"event_by_id"})
    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Event> getEvent(@PathVariable Long eventId) {
        return new ResponseEntity<Event>(eventService.getEvent(eventId), HttpStatus.OK);
    }

    @ApiOperation(value = "This will get one event by its title.", nickname = "Witcher")
    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Event> getAllEventsByTitle(@PathVariable String title) {
        return eventService.getAllEventsByTitle(title);
    }

    @ApiOperation(value = "This will create new event.", tags = {"NEW Event API"})
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return new ResponseEntity<Event>(eventService.createEvent(event), HttpStatus.CREATED);
    }

    @ApiOperation(value = "This operation updates existing event.", notes = "Some really important notes about this operation")
    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.updateEvent(event), HttpStatus.OK);
    }

    @ApiOperation(value = "This will remove one event.", nickname = "Remover")
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

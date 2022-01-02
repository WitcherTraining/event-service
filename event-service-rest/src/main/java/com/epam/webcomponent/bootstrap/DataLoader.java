package com.epam.webcomponent.bootstrap;

import com.epam.impl.EventServiceImpl;
import com.epam.model.Event;
import com.epam.model.EventType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventServiceImpl eventService;

    public DataLoader(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @Override
    public void run(String... args) {
        int count = eventService.getAllEvents().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {

        Event event = new Event();
        event.setTitle("title");
        event.setEventType(EventType.VIP);
        event.setDateTime(LocalDateTime.now());
        event.setPlace("place1");
        event.setSpeaker("speaker");

        eventService.createEvent(event);

        Event event2 = new Event();
        event2.setTitle("title2");
        event2.setEventType(EventType.PREMIUM);
        event2.setDateTime(LocalDateTime.now());
        event2.setPlace("place2");
        event2.setSpeaker("speaker2");

        eventService.createEvent(event2);


        System.out.println("Events data loaded...");
    }
}

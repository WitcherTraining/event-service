package com.epam.impl;

import com.epam.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findAll();
    List<Event> findAllByTitle(String title);
}

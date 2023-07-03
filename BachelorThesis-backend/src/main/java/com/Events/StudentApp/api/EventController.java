package com.Events.StudentApp.api;

import com.Events.StudentApp.beans.EventRequest;
import com.Events.StudentApp.service.EventService;
import com.Events.StudentApp.token.EventRepository;
import com.Events.StudentApp.user.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventRepository eventRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@RequestBody EventRequest eventRequest) {
        return eventService.createEvent(eventRequest);
    }

    @GetMapping("/load")
    public ResponseEntity<?> loadAllEvents() {
        return eventService.getAllEvents();
    }

    @DeleteMapping("/delete")
    public void deleteEvent(@RequestParam Integer id) {
        eventService.deleteEvent(id);
    }

    @GetMapping("/page")
    public ResponseEntity<?> paginateEvent(@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
                                           @RequestParam(value = "perPage", defaultValue = "6") int perPage
                                           ) {
        Pageable pagable = PageRequest.of(currentPage - 1, perPage);
        Page<Event> events = eventRepository.findEvents(pagable);
        Map<String, Object> response = new HashMap<>();
        response.put("events", events.getContent());
        response.put("currentPage", events.getNumber()+1);
        response.put("totalItems", events.getTotalElements());
        response.put("totalPages", events.getTotalPages());

        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/myEvents")
    public ResponseEntity<?> findAllEventsByUser() {
        return eventService.findAllEventsByUserId();
    }
}

package com.Events.StudentApp.api;

import com.Events.StudentApp.beans.EventRequest;
import com.Events.StudentApp.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

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
}

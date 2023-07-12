package com.Events.StudentApp.service;

import com.Events.StudentApp.beans.EventRequest;
import com.Events.StudentApp.token.EventRepository;
import com.Events.StudentApp.user.Event;
import com.Events.StudentApp.user.User;
import com.Events.StudentApp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createEvent(EventRequest eventRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepository.findByEmail(auth.getPrincipal().toString());
        Event newEvent = new Event();
            newEvent.setName(eventRequest.getName());
            newEvent.setStartDateTime(eventRequest.getStartDateTime());
            newEvent.setEndDateTime(eventRequest.getEndDateTime());
            newEvent.setDescription(eventRequest.getDescription());
            newEvent.setCity(eventRequest.getCity());
            newEvent.setUser(((User)auth.getPrincipal()));

            eventRepository.save(newEvent);
            return ResponseEntity.ok().body(newEvent);
    }

    public ResponseEntity<?> getAllEvents(@RequestParam Pageable page) {
        var returnAllEvents =  eventRepository.findEvents(page);
        System.out.println(returnAllEvents);
        return ResponseEntity.ok().body(returnAllEvents);
    }

    public void deleteEvent(Integer id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        eventRepository.findById(id).ifPresent(event -> eventRepository.delete(event));
    }

    public ResponseEntity<?> findAllEventsByUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        var returnAllEventsByUser = eventRepository.findAllEventsByUser(((User)auth.getPrincipal()).getId());
        System.out.println(returnAllEventsByUser);
        return ResponseEntity.ok().body(returnAllEventsByUser);
    }

    public Page<Event> getEventByNameOrCity(@RequestParam Pageable page, @RequestParam String name) {
        Page<Event> result = eventRepository.findEventByNameOrCity(page, name);
        return result;
    }
}

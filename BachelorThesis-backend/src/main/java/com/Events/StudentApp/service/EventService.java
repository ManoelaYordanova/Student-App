package com.Events.StudentApp.service;

import com.Events.StudentApp.beans.EventRequest;
import com.Events.StudentApp.token.EventRepository;
import com.Events.StudentApp.user.Event;
import com.Events.StudentApp.user.User;
import com.Events.StudentApp.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<?> getAllEvents() {
        var returnAllEvents =  eventRepository.findAll();
        System.out.println(returnAllEvents);
        return ResponseEntity.ok().body(returnAllEvents);
    }

    public void deleteEvent(Integer id) {
        eventRepository.findById(id).ifPresent(event -> eventRepository.delete(event));
    }
}

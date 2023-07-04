package com.Events.StudentApp.token;

import com.Events.StudentApp.beans.EventRequest;
import com.Events.StudentApp.user.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("SELECT e FROM Event e")
    Page<Event> findEvents(Pageable pageable);

    @Query("SELECT e FROM Event e WHERE e.user.id = :userId")
    List<Event> findAllEventsByUser(Integer userId);

    @Query("SELECT e FROM Event e WHERE LOWER(e.name) LIKE CONCAT('%',LOWER(:name),'%') OR LOWER(e.city) LIKE CONCAT('%',LOWER(:name),'%')")
    Page<Event> findEventByNameOrCity(Pageable pageable, String name);

}

package com.Events.StudentApp.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "_event")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Timestamp startDateTime;

    private Timestamp endDateTime;

    private String description;

    private String city;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

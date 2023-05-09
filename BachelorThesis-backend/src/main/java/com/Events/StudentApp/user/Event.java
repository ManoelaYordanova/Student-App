package com.Events.StudentApp.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
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

    private Date startDate;

    private Date endDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.app.eventBooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    @ManyToOne
    private Attendee primaryAttendee;
    @ManyToOne
    private Organizer addedByOrganizer;
    @OneToOne
    private Event event;
}

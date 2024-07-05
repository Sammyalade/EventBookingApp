package com.app.eventBooking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Entity
@ToString
@Table(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String city;
    private String state;
    @OneToMany
    private List<Event> eventList;
}

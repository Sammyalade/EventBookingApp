package com.app.eventBooking.dtos.request;

import com.app.eventBooking.models.Attendee;
import com.app.eventBooking.models.Organizer;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GuestRequest {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private Long primaryAttendeeId;
    private Long addedByOrganizerId;
    private Long eventId;
}

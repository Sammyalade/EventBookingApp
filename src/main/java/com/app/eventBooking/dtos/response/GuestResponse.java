package com.app.eventBooking.dtos.response;

import com.app.eventBooking.dtos.request.AttendeeRequest;
import com.app.eventBooking.dtos.request.EventRequest;
import com.app.eventBooking.dtos.request.OrganizerRequest;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GuestResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String attendeeName;
    private String organizerName;
    private EventRequest event;
}

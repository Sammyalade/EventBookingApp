package com.app.eventBooking.services.impl;

import com.app.eventBooking.exceptions.OrganizerNotFoundException;
import com.app.eventBooking.models.Organizer;
import com.app.eventBooking.repositories.OrganizerRepository;
import com.app.eventBooking.services.layer.OrganizerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingOrganizerImpl implements OrganizerService {

    private OrganizerRepository organizerRepository;


    @Override
    public Organizer findById(Long id) throws OrganizerNotFoundException {
        return organizerRepository.findById(id).orElseThrow(
                ()-> new OrganizerNotFoundException("Organizer not found")
        );
    }
}

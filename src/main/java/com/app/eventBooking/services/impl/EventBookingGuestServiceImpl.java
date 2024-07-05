package com.app.eventBooking.services.impl;

import com.app.eventBooking.dtos.request.GuestRequest;
import com.app.eventBooking.dtos.response.GuestDeleteResponse;
import com.app.eventBooking.dtos.response.GuestResponse;
import com.app.eventBooking.exceptions.*;
import com.app.eventBooking.models.Attendee;
import com.app.eventBooking.models.Guest;
import com.app.eventBooking.models.Organizer;
import com.app.eventBooking.repositories.GuestRepository;
import com.app.eventBooking.services.layer.AttendeeService;
import com.app.eventBooking.services.layer.EventService;
import com.app.eventBooking.services.layer.GuestService;
import com.app.eventBooking.services.layer.OrganizerService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class EventBookingGuestServiceImpl implements GuestService {

    private GuestRepository guestRepository;
    private AttendeeService attendeeService;
    private EventService eventService;
    private OrganizerService organizerService;
    private ModelMapper modelMapper;
    private ObjectMapper objectMapper;
    @Override
    public GuestResponse createGuest(GuestRequest guestRequest)
            throws AttendeeNotFoundException, OrganizerNotFoundException,
            EventNotFoundException, GuestInviteViolationException {
        Guest guest = modelMapper.map(guestRequest, Guest.class);
        if(guestRequest.getPrimaryAttendeeId() != null && guestRequest.getAddedByOrganizerId() != null){
            throw new GuestInviteViolationException
                    ("Guest cannot be invited by both organizer and attendee");
        }
        if(guestRequest.getPrimaryAttendeeId() != null) guest.setPrimaryAttendee
                (attendeeService.findById(guestRequest.getPrimaryAttendeeId()));
        else guest.setAddedByOrganizer
                (organizerService.findById(guestRequest.getAddedByOrganizerId()));
        guest.setEvent(eventService.findById(guestRequest.getEventId()));
        guestRepository.save(guest);
        return modelMapper.map(guest, GuestResponse.class);
    }



    @Override
    public GuestResponse updateGuest(GuestRequest guestRequest) throws GuestNotFoundException,
            IOException {
        Guest guest = findById(guestRequest.getId());
        JsonNode guestRequestNode = objectMapper.convertValue(guestRequest, JsonNode.class);

        List<JsonNode> patchOperations = new ArrayList<>();
        Iterator<String> fieldNames = guestRequestNode.fieldNames();
        while (fieldNames.hasNext()) {
            String fieldName = fieldNames.next();
            if (!fieldName.equals("primaryAttendeeId") && !fieldName.equals("addedByOrganizerId")
                    && !fieldName.equals("eventId")) {
                JsonNode valueNode = guestRequestNode.get(fieldName);
                ObjectNode operation = objectMapper.createObjectNode();
                operation.put("op", "replace");
                operation.put("path", "/" + fieldName);
                operation.set("value", valueNode);
                patchOperations.add(operation);
            }
        }

        JsonPatch jsonPatch = JsonPatch.fromJson(objectMapper.valueToTree(patchOperations));

        try {
            JsonNode patchedGuestNode = jsonPatch.apply(objectMapper.valueToTree(guest));
            Guest patchedGuest = objectMapper.convertValue(patchedGuestNode, Guest.class);
            guestRepository.save(patchedGuest);
            return modelMapper.map(patchedGuest, GuestResponse.class);
        } catch (JsonPatchException e) {
            throw new IOException("Failed to apply JSON Patch to Guest entity", e);
        }
    }

    @Override
    public GuestDeleteResponse deleteGuest(GuestRequest guestRequest)
            throws GuestNotFoundException, OrganizerNotFoundException, AttendeeNotFoundException {
        Guest guest = findById(guestRequest.getId());
        Organizer organizer = organizerService.findById(guestRequest.getAddedByOrganizerId());
        Attendee attendee = attendeeService.findById(guestRequest.getPrimaryAttendeeId());

        boolean organizerIsNotNullAndIsEquals = guest.getAddedByOrganizer() != null
                && guest.getAddedByOrganizer().equals(organizer);
        boolean attendeeIsNotNullAndIsEquals = guest.getPrimaryAttendee() != null
                && guest.getPrimaryAttendee().equals(attendee);

        if(organizerIsNotNullAndIsEquals ||attendeeIsNotNullAndIsEquals){
            guestRepository.delete(guest);
            GuestDeleteResponse response = new GuestDeleteResponse();
            response.setMessage("Guest Deleted");
            return response;
        }
        throw new GuestNotFoundException("Guest does not exist on your list");
    }

    @Override
    public Guest findById(Long id) throws GuestNotFoundException {
        return guestRepository.findById(id).orElseThrow(
                ()-> new GuestNotFoundException("Guest does not exist")
        );
    }
}

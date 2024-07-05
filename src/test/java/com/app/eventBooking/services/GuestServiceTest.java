package com.app.eventBooking.services;

import com.app.eventBooking.dtos.request.GuestRequest;
import com.app.eventBooking.dtos.response.GuestDeleteResponse;
import com.app.eventBooking.dtos.response.GuestResponse;
import com.app.eventBooking.exceptions.*;
import com.app.eventBooking.services.layer.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
public class GuestServiceTest {

    @Autowired
    private GuestService guestService;

    @Test
    public void createGuest_guestIsCreatedTest() throws AttendeeNotFoundException,
            EventNotFoundException, OrganizerNotFoundException, GuestInviteViolationException {
        GuestRequest request = getGuestRequest();
        request.setAddedByOrganizerId(null);
        GuestResponse response = guestService.createGuest(request);
        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
    }

    private static GuestRequest getGuestRequest() {
        GuestRequest request = new GuestRequest();
        request.setEventId(200L);
        request.setAddedByOrganizerId(10L);
        request.setPrimaryAttendeeId(100L);
        request.setEmail("email@email.com");
        request.setName("John doe");
        request.setAddress("Address");
        request.setCity("Lagos");
        request.setCountry("Nigeria");
        request.setPhone("08065627354");
        return request;
    }

    @Test
    public void createGuest_updateGuestService_guestIsUpdatedTest()
            throws AttendeeNotFoundException, EventNotFoundException, OrganizerNotFoundException,
            IOException, GuestNotFoundException, GuestInviteViolationException {
        GuestRequest firstRequest = getGuestRequest();
        firstRequest.setAddedByOrganizerId(null);
        GuestResponse response = guestService.createGuest(firstRequest);
        GuestRequest request = getGuestRequest();
        request.setId(response.getId());
        response = guestService.updateGuest(request);
        assertThat(response).isNotNull();
        assertThat(response.getName()).isNotNull();
    }

    @Test
    public void createGuest_deleteGuest_guestIsDeletedTest()
            throws AttendeeNotFoundException, OrganizerNotFoundException,
            GuestNotFoundException, EventNotFoundException, GuestInviteViolationException {
        GuestRequest firstRequest = getGuestRequest();
        firstRequest.setAddedByOrganizerId(null);
        GuestResponse response = guestService.createGuest(firstRequest);
        GuestRequest request = getGuestRequest();
        request.setId(response.getId());
        GuestDeleteResponse response1 = guestService.deleteGuest(request);
        assertThat(response1).isNotNull();
        assertThat(response1.getMessage()).isNotNull();
    }

    @Test
    public void searchForGuestThatDoesNotExist_throwsAnExceptionTest(){
        assertThatThrownBy(
                ()-> guestService.findById(1000L)
        )
                .isInstanceOf(GuestNotFoundException.class)
                .hasMessageContaining("Guest does not exist");
    }

    @Test
    public void sendUpdateRequestWithGuestIdThatDoesNotExist_throwsAnExceptionTest()
            throws AttendeeNotFoundException, EventNotFoundException,
            OrganizerNotFoundException, GuestInviteViolationException {
        GuestRequest firstRequest = getGuestRequest();
        firstRequest.setAddedByOrganizerId(null);
        GuestResponse response = guestService.createGuest(firstRequest);
        GuestRequest request = getGuestRequest();
        request.setId(1000L);
        assertThatThrownBy(
                ()->guestService.updateGuest(request)
        )
                .isInstanceOf(GuestNotFoundException.class)
                .hasMessageContaining("Guest does not exist");
    }

    @Test
    public void sendInGuestRequestWithEventThatDoesNotExist_throwsExceptionTest() {
        GuestRequest request = getGuestRequest();
        request.setAddedByOrganizerId(null);
        request.setEventId(1000L);
        assertThatThrownBy(
                ()-> guestService.createGuest(request)
        )
                .isInstanceOf(EventNotFoundException.class)
                .hasMessageContaining("Event does not exist");
    }

    @Test
    public void sendInGuestRequestWithAttendeeThatDoesNotExist_throwsExceptionTest(){
        GuestRequest request = getGuestRequest();
        request.setPrimaryAttendeeId(1000L);
        request.setAddedByOrganizerId(null);
        assertThatThrownBy(
                ()-> guestService.createGuest(request)
        )
                .isInstanceOf(AttendeeNotFoundException.class)
                .hasMessageContaining("Attendee not available");
    }

    @Test
    public void sendInGuestRequestWithOrganizerThatDoesNotExist_throwsExceptionTest(){
        GuestRequest request = getGuestRequest();
        request.setPrimaryAttendeeId(null);
        request.setAddedByOrganizerId(1000L);
        assertThatThrownBy(
                ()-> guestService.createGuest(request)
        )
                .isInstanceOf(OrganizerNotFoundException.class)
                .hasMessageContaining("Organizer not found");
    }

    @Test
    public void sendInGuestRequestWithOrganizerAndAttendeeInvitingTheSameGuest_throwsExceptionTest(){
        GuestRequest request = getGuestRequest();
        request.setAddedByOrganizerId(1000L);
        assertThatThrownBy(
                ()-> guestService.createGuest(request)
        )
                .isInstanceOf(GuestInviteViolationException.class)
                .hasMessageContaining
                        ("Guest cannot be invited by both organizer and attendee");
    }



}

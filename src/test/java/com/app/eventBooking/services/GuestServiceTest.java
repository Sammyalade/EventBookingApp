package com.app.eventBooking.services;

import com.app.eventBooking.dtos.request.GuestRequest;
import com.app.eventBooking.services.layer.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GuestServiceTest {

    @Autowired
    private GuestService guestService;

    @Test
    public void createGuest_guestIsCreatedTest(){
        GuestRequest request = new GuestRequest();

    }
}

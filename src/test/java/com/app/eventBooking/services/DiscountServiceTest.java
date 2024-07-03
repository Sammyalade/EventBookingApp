package com.app.eventBooking.services;

import com.app.eventBooking.dtos.request.DiscountRequest;
import com.app.eventBooking.dtos.response.DiscountResponse;
import com.app.eventBooking.exceptions.DiscountNotFoundException;
import com.app.eventBooking.services.layer.DiscountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void createDiscount_discountIsCreatedTest(){
        DiscountRequest discountRequest = new DiscountRequest();
        discountRequest.setPercentageDiscount(10);
        DiscountResponse response = discountService.createDiscount(discountRequest);
        assertThat(response).isNotNull();
        assertThat(response.getId()).isNotNull();
    }

    @Test
    public void createDiscount_updateDiscount_discountIsUpdatedTest() throws DiscountNotFoundException {
        DiscountRequest discountRequest = new DiscountRequest();
        discountRequest.setPercentageDiscount(10);
        DiscountResponse response = discountService.createDiscount(discountRequest);
        discountRequest.setId(response.getId());
        discountRequest.setPercentageDiscount(20);
        response = discountService.updateDiscount(discountRequest);
        assertThat(response).isNotNull();
        assertThat(response.getPercentageDiscount()).isEqualTo(20);
    }
}

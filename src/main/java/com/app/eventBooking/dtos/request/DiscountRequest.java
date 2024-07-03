package com.app.eventBooking.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiscountRequest {

    private Long id;
    private int percentageDiscount;
}

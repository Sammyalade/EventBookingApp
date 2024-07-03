package com.app.eventBooking.services.layer;

import com.app.eventBooking.dtos.request.DiscountRequest;
import com.app.eventBooking.dtos.response.DiscountResponse;
import com.app.eventBooking.exceptions.DiscountNotFoundException;

public interface DiscountService {

    DiscountResponse createDiscount(DiscountRequest discountRequest);
    DiscountResponse updateDiscount(DiscountRequest discountRequest) throws DiscountNotFoundException;
}

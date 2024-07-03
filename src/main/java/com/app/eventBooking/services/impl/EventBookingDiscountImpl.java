package com.app.eventBooking.services.impl;

import com.app.eventBooking.dtos.request.DiscountRequest;
import com.app.eventBooking.dtos.response.DiscountResponse;
import com.app.eventBooking.exceptions.DiscountNotFoundException;
import com.app.eventBooking.models.Discount;
import com.app.eventBooking.repositories.DiscountRepository;
import com.app.eventBooking.services.layer.DiscountService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventBookingDiscountImpl implements DiscountService {

    private ModelMapper modelMapper;
    private DiscountRepository discountRepository;

    @Override
    public DiscountResponse createDiscount(DiscountRequest discountRequest) {
        Discount discount = modelMapper.map(discountRequest, Discount.class);
        discountRepository.save(discount);
        return modelMapper.map(discount, DiscountResponse.class);
    }

    @Override
    public DiscountResponse updateDiscount(DiscountRequest discountRequest) throws DiscountNotFoundException {
        Discount discount = findDiscountById(discountRequest.getId());
        modelMapper.map(discountRequest, discount);
        discountRepository.save(discount);
        return modelMapper.map(discount, DiscountResponse.class);
    }

    private Discount findDiscountById(Long id) throws DiscountNotFoundException {
        return discountRepository.findById(id).orElseThrow(
                ()-> new DiscountNotFoundException("Discount not found")
        );
    }
}

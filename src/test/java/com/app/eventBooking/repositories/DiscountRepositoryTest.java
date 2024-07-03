package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Discount;
import com.app.eventBooking.models.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DiscountRepositoryTest {

    @Autowired
    private DiscountRepository discountRepository;

    @Test
    void testGuestRepository() {
        Discount discount = new Discount();
        discountRepository.save(discount);
        assertThat(discountRepository.count()).isEqualTo(1L);
    }
}

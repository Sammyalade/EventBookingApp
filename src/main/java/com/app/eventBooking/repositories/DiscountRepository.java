package com.app.eventBooking.repositories;

import com.app.eventBooking.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}

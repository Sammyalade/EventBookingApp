package com.app.eventBooking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue
    private Long id;
    private int percentageDiscount;
}

package br.edu.fema.order_client.dto;

import java.time.LocalDateTime;

public record OrderRequestDto(
        String product_name,
        int quantity,
        float unit_price,
        LocalDateTime order_date,
        PaymentDto payment
) {}

package br.edu.fema.order_client.dto;

public record OrderResponseDto(
        String productName,
        String status,
        String estimatedDeliveryDate,
        String createdAt,
        PaymentDto payment
) {
}

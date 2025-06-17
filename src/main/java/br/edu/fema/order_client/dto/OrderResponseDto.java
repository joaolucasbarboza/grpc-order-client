package br.edu.fema.order_client.dto;

public record OrderResponseDto(
        String id,
        String status,
        String estimatedDeliveryDate,
        String trackingCode,
        String createdAt,
        String paymentMethod,
        String cardBrand,
        int instalments
) {
}

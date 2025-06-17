package br.edu.fema.order_client.dto;

public record PaymentDto(
        String method,
        CreditCardDto credit_card
) {
}

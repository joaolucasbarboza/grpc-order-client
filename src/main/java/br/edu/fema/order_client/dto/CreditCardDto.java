package br.edu.fema.order_client.dto;

public record CreditCardDto(
        Integer instalments,
        String card_brand
) {
}

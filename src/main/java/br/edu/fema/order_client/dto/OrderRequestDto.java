package br.edu.fema.order_client.dto;

public record OrderRequestDto(
        String product,
        int quantity
) {}

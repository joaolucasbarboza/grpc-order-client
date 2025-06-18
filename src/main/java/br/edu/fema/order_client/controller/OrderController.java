package br.edu.fema.order_client.controller;

import br.edu.fema.grpc.OrderResponse;
import br.edu.fema.order_client.dto.CreditCardDto;
import br.edu.fema.order_client.dto.OrderRequestDto;
import br.edu.fema.order_client.dto.OrderResponseDto;
import br.edu.fema.order_client.dto.PaymentDto;
import br.edu.fema.order_client.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto request) {
        OrderResponse response = orderService.createOrder(request);

        PaymentDto paymentDto = new PaymentDto(
                response.getPayment().getMethod(),
                response.getPayment().hasCreditCard() ? new CreditCardDto(
                        response.getPayment().getCreditCard().getInstalments(),
                        response.getPayment().getCreditCard().getCardBrand()
                ) : null
        );

        OrderResponseDto responseDto = new OrderResponseDto(
                response.getProductName(),
                response.getStatus(),
                response.getEstimatedDeliveryDate(),
                response.getCreatedAt(),
                paymentDto
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}

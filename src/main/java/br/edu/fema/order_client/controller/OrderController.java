package br.edu.fema.order_client.controller;

import br.edu.fema.order_client.dto.OrderRequestDto;
import br.edu.fema.order_client.service.OrderServiceImpl;
import lombok.AllArgsConstructor;
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
    public ResponseEntity createOrder(@RequestBody OrderRequestDto request) {
        orderService.createOrder(request);

        return ResponseEntity.ok().build();
    }
}

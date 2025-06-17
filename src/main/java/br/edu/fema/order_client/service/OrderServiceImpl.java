package br.edu.fema.order_client.service;

import br.edu.fema.grpc.*;
import br.edu.fema.order_client.dto.OrderRequestDto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  {

    @GrpcClient("orderService")
    private OrderServiceGrpc.OrderServiceBlockingStub serviceBlockingStub;

    public OrderResponse createOrder(OrderRequestDto request) {

        CreditCard creditCard = CreditCard.newBuilder()
                .setInstalments(request.payment().credit_card().instalments())
                .setCardBrand(request.payment().credit_card().card_brand())
                .build();

        Payment payment = Payment.newBuilder()
                .setMethod(request.payment().method())
                .setCreditCard(creditCard)
                .build();

        OrderRequest order = OrderRequest
                .newBuilder()
                .setProductName(request.product_name())
                .setQuantity(request.quantity())
                .setUnitPrice(request.unit_price())
                .setPayment(payment)
                .build();

        return serviceBlockingStub.createOrder(order);
    }
}

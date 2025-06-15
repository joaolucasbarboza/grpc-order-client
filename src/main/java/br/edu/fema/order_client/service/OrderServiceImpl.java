package br.edu.fema.order_client.service;

import br.edu.fema.grpc.OrderRequest;
import br.edu.fema.grpc.OrderResponse;
import br.edu.fema.grpc.OrderServiceGrpc;
import br.edu.fema.order_client.dto.OrderRequestDto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  {

    @GrpcClient("orderService")
    private OrderServiceGrpc.OrderServiceBlockingStub serviceBlockingStub;

    public OrderResponse createOrder(OrderRequestDto request) {
        OrderRequest order = OrderRequest
                .newBuilder()
                .setProduct(request.product())
                .setQuantity(request.quantity())
                .build();

        return serviceBlockingStub.createOrder(order);
    }
}

package br.edu.fema.order_client.service;

import br.edu.fema.grpc.OrderRequest;
import br.edu.fema.grpc.OrderResponse;
import br.edu.fema.grpc.OrderServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  {

    @GrpcClient("orderService")
    private OrderServiceGrpc.OrderServiceBlockingStub serviceBlockingStub;

    public OrderResponse createOrder(String id) {
        OrderRequest request = OrderRequest.newBuilder().setId(id).build();
        return serviceBlockingStub.createOrder(request);
    }
}

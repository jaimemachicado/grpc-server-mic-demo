package com.jaimemachicado.grpcservermicdemo.service;


import com.example.grpc.server.grpcserver.HelloRequest;
import com.example.grpc.server.grpcserver.HelloResponse;
import com.example.grpc.server.grpcserver.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class HelloServiceImpl extends HelloServiceImplBase {

  @Override
  public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
    String responseMsg = new StringBuilder().append("Hello, ").append(request.getTitle())
        .append(" ").append(request.getDescription()).append(" with URL=").append(request.getUrl())
        .toString();

    System.out.println("La respuesta sera: ".concat(responseMsg));

    HelloResponse response = HelloResponse.newBuilder().setGreeting(responseMsg).build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}

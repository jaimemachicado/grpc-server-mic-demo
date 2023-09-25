package com.jaimemachicado.grpcservermicdemo;

import com.jaimemachicado.grpcservermicdemo.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcServerMicDemoApplication {

  public static void main(String[] args) throws IOException, InterruptedException {
    Server server = ServerBuilder
        .forPort(8080)
        .addService(new HelloServiceImpl()).build();
    server.start();
    System.out.println("Server started at " + server.getPort());
    server.awaitTermination();
    SpringApplication.run(GrpcServerMicDemoApplication.class, args);


  }

}

//package main.java.com.example.demo.config;
package com.example.demo.config;

@Configuration
public class MilvusConfig {

    @Bean
    public MilvusClient milvusClient() {
        ConnectParam connectParam = ConnectParam.newBuilder()
                .withHost("localhost")
                .withPort(19530)
                .build();
        return new MilvusServiceClient(connectParam);
    }
}

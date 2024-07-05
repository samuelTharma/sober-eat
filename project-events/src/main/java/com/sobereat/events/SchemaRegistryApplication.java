package com.sobereat.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SchemaRegistryApplication
{
  public static void main(String[] args)
  {
    System.out.println("Starting Schema registry");
    SpringApplication.run(SchemaRegistryApplication.class);
  }

 // @Value("${spring.cloud.stream.kafka.binder.producer-properties.schema.registry.url}")
  private String endPoint="http://localhost:8081";

  @Bean
  public SchemaRegistryClient schemaRegistryClient() {
    ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
    client.setEndpoint(endPoint);
    return client;
  }
}
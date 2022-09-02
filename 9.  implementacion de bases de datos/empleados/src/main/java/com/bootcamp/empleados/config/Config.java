package com.bootcamp.empleados.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("com.bootcamp.empleados.repository")
public class Config {
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration config = ClientConfiguration.builder()
                .connectedTo("localhost:9200")
                .build();
        return RestClients.create(config).rest();
    }
}

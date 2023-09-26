package com.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    @Value("${spring.rabbitmq.queue.name}")
    private String queueName;
    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeName;
    @Value("${spring.rabbitmq.routingkey.name}")
    private String routingKey;
    private RabbitTemplate rabbitTemplate;
    public RabbitMqConfiguration(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }
    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingKey);
    }
}

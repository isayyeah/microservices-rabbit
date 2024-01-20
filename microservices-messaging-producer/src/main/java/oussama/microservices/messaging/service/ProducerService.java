package oussama.microservices.messaging.service;

import oussama.microservices.messaging.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    @Value("${spring.rabbitmq.exchange}2")
    private String exchange2;

    @Value("${spring.rabbitmq.routingkey}2")
    private String routingkey2;

    public void sendMessage(User user) {
        rabbitTemplate.convertAndSend(exchange,routingkey, user);
    }


    public void sendMessage2(User user) {
        rabbitTemplate.convertAndSend(exchange2,routingkey2, user);
    }
}

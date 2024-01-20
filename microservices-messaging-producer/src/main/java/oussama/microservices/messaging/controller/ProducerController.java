package oussama.microservices.messaging.controller;

import oussama.microservices.messaging.domain.User;
import oussama.microservices.messaging.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ProducerController {

    private ProducerService producerService;
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @Value("${app.message}")
    private String response;

    @PostMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestBody User user) {
        producerService.sendMessage(user);
        logger.info("user sent: " + user);
        return ResponseEntity.ok("user sent: " + user);
    }

    @PostMapping("/produce2")
    public ResponseEntity<String> sendMessage2(@RequestBody User user) {
        producerService.sendMessage2(user);
        logger.info("user sent: " + user);
        return ResponseEntity.ok("user sent: " + user);
    }
}

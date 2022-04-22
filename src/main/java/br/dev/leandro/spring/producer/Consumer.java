package br.dev.leandro.spring.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Consumer {


//    @JmsListener(destination = "spring-queue")
//    public void consumeMessage(String message) {
//        log.info("Message received from activemq queue---"+message);
//    }
}

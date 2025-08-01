package matheus_nicolau.credit.queue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreditReceiveConsumer {

    @RabbitListener(queues = "${mq.queues.credit-emission}")
    public void receiveSolicitation(@Payload String message) {
        System.out.println("Enviando mensagem para o RabbitMQ: " + message);
    }
}

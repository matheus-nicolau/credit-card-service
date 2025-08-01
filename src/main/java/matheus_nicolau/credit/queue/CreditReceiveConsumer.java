package matheus_nicolau.credit.queue;

import com.google.gson.Gson;
import matheus_nicolau.credit.dto.CreditDTO;
import matheus_nicolau.credit.exceptions.ExceptionMessages;
import matheus_nicolau.credit.service.CreditService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CreditReceiveConsumer {

    private final CreditService creditService;

    public CreditReceiveConsumer(CreditService creditService) {
        this.creditService = creditService;
    }

    @RabbitListener(queues = "${mq.queues.credit-emission}")
    public void receiveSolicitation(@Payload String json) {
        try {
            Gson gson = new Gson();
            CreditDTO credit = gson.fromJson(json, CreditDTO.class);
            
            if (null == credit){
                throw new AmqpRejectAndDontRequeueException(ExceptionMessages.PAYLOAD_NOT_FOUND.message());
            }
            creditService.createCredit(credit);
            
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException(ExceptionMessages.BAD_SOLICITATION.message());
        }

    }
}

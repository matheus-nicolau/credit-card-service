package matheus_nicolau.credit.controllers;

import matheus_nicolau.credit.dto.CreditDTO;
import matheus_nicolau.credit.queue.CreditReceiveConsumer;
import matheus_nicolau.credit.service.CreditService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CreditController {

    private final CreditService creditService;
    private final CreditReceiveConsumer creditConsumer;

    public CreditController(CreditService creditService, CreditReceiveConsumer creditConsumer) {
        this.creditService = creditService;
        this.creditConsumer = creditConsumer;
    }

    @GetMapping("/credit/list/{limit}")
    public ResponseEntity<List<CreditDTO>> listCreditByValue(@PathVariable String limit) {
        List<CreditDTO> creditList= creditService.listCreditByValue(limit);
        return new ResponseEntity<>(creditList, HttpStatus.CREATED);
    }

    @PostMapping("/credit/list")
    public ResponseEntity<String> consumerCreateCredit(@RequestBody String credit) {
        creditConsumer.receiveSolicitation(credit);
        return new ResponseEntity<>("Crédito salvo com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/credit/create")
    public ResponseEntity<String> createCredit(@RequestBody CreditDTO credit) {
        creditService.createCredit(credit);
        return new ResponseEntity<>("Crédito salvo com sucesso", HttpStatus.CREATED);
    }
}

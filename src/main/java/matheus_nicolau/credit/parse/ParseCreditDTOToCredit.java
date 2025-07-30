package matheus_nicolau.credit.parse;

import matheus_nicolau.credit.dto.CreditDTO;
import matheus_nicolau.credit.entity.Credit;
import org.springframework.stereotype.Component;

@Component
public class ParseCreditDTOToCredit {

    public Credit parse(CreditDTO credit) {
        return new Credit(credit.name(), credit.brand(), credit.income(), credit.limitation());
    }
}

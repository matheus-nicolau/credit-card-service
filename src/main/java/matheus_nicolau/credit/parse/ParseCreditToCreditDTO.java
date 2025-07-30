package matheus_nicolau.credit.parse;

import matheus_nicolau.credit.dto.CreditDTO;
import matheus_nicolau.credit.entity.Credit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParseCreditToCreditDTO {

    public CreditDTO parse(Credit credit) {
        return new CreditDTO(credit.getName(), credit.getBrand(), credit.getIncome(), credit.getLimitation());
    }

    public List<CreditDTO> parseAll(List<Credit> creditList) {
        return creditList.stream().map(credit -> new CreditDTO(credit.getName(), credit.getBrand(),
                                                                      credit.getIncome(), credit.getLimitation())).toList();
    }
}

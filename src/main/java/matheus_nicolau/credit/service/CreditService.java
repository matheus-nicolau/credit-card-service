package matheus_nicolau.credit.service;

import jakarta.transaction.Transactional;
import matheus_nicolau.credit.dto.CreditDTO;
import matheus_nicolau.credit.entity.Credit;
import matheus_nicolau.credit.exceptions.CreditAlreadyExistsException;
import matheus_nicolau.credit.parse.ParseCreditDTOToCredit;
import matheus_nicolau.credit.parse.ParseCreditToCreditDTO;
import matheus_nicolau.credit.repository.CreditRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService {

    private final ParseCreditDTOToCredit parseCredit;
    private final ParseCreditToCreditDTO parseCreditDTO;
    private final CreditRepository creditRepository;

    public CreditService(ParseCreditDTOToCredit parseCredit, ParseCreditToCreditDTO parseCreditDTO,
                         CreditRepository creditRepository) {
        this.parseCredit = parseCredit;
        this.parseCreditDTO = parseCreditDTO;
        this.creditRepository = creditRepository;
    }

    @Transactional
    public void createCredit(CreditDTO credit) {
        Credit parse = parseCredit.parse(credit);
        creditRepository.findOneByName(credit.name()).ifPresent(creditOptional -> {
            throw new CreditAlreadyExistsException("Credito já cadastrado");
        });
        creditRepository.save(parse);
    }

    public List<CreditDTO> listCreditByValue(String limit) {
        Long limitValue = Long.parseLong(limit);
        return creditRepository.findAll().stream()
                                         .filter(credit -> credit.getLimitation() <= limitValue)
                                         .map(parseCreditDTO::parse)
                                         .toList();
    }
}

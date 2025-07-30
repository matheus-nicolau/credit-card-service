package matheus_nicolau.credit.repository;

import matheus_nicolau.credit.entity.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CreditRepository extends JpaRepository<Credit, UUID> {
    Optional<Credit> findOneByName(String name);
}

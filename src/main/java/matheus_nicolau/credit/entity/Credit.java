package matheus_nicolau.credit.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String brand;
    private Long income;
    private Long limitation;

    @Deprecated
    public Credit() {}

    public Credit(String name, String brand, Long income, Long limitation) {
        this.limitation = limitation;
        this.income = income;
        this.brand = brand;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Long getIncome() {
        return income;
    }

    public Long getLimitation() {
        return limitation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Credit credit = (Credit) o;
        return Objects.equals(id, credit.id) && Objects.equals(name, credit.name)
                && Objects.equals(brand, credit.brand) && Objects.equals(income, credit.income)
                && Objects.equals(limitation, credit.limitation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, brand, income, limitation);
    }
}

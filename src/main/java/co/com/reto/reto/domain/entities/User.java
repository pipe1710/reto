package co.com.reto.reto.domain.entities;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User {

    @Id
    private Long id;

    @Column("name")
    @NotBlank(message = "Nombre Requerido")
    private String name;

    @Column("balance")
    private double balance;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nombre Requerido") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Nombre Requerido") String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

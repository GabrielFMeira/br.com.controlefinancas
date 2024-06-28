package br.com.controlefinancas.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double valor;

    private String name;

    @ManyToOne
    private Owner owner;

    private BillType billType;

    private LocalDateTime billExpiring;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public BillType getBillType() {
        return billType;
    }

    public void setBillType(BillType billType) {
        this.billType = billType;
    }

    public LocalDateTime getBillExpiring() {
        return billExpiring;
    }

    public void setBillExpiring(LocalDateTime billExpiring) {
        this.billExpiring = billExpiring;
    }
}

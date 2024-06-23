package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import br.com.controlefinancas.entity.Owner;

import java.util.List;

public interface BillService {

    public List<Bill> list();

    public Bill findById(Long id);

    public List<Bill> findByOwner(Owner owner);

    public Bill save (Bill bill);

    public void changeType(Long id, BillType billType);

    public int totalValuePercentage(Owner owner);

    public int regraDeTres(double salary, double totalValue);
}

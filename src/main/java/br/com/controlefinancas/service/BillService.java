package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;

import java.util.List;

public interface BillService {

    public List<Bill> list();

    public Bill findById(Long id);

    public Bill save (Bill bill);

    public void changeType(Long id, BillType billType);
}

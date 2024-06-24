package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import br.com.controlefinancas.entity.Owner;
import br.com.controlefinancas.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository){
        this.billRepository = billRepository;
    }

    public List<Bill> list() {
        return billRepository.findAll();
    }


    public Bill findById(Long id){
        return billRepository.findById(id).orElse(null);
    }

    public List<Bill> findByOwner(Owner owner) {
        return billRepository.findByOwner(owner);
    }

    public Bill save(Bill bill){
        billRepository.save(bill);
        return bill;
    }

    public void changeType(Long id, BillType billType) {
         billRepository.updateMovieType(id, billType);
    }

    // Deve retornar a porcentagem do salário usado
    public int totalValuePercentage(Owner owner) {
        List<Bill> contas = billRepository.findByOwner(owner);
        double valorTotal = 0;
        for (Bill conta : contas) {
            valorTotal += conta.getValor();
        }
        return this.regraDeTres(owner.getSalary(), valorTotal);
    }

    public int regraDeTres(double salary, double totalValue) {
        double usedPercentage = (100 * totalValue) / salary;
        return (int) usedPercentage;
    }
}

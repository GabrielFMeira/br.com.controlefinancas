package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
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

    public List<Bill> List() {
        return billRepository.findAll();
    }


    public Bill findById(Long id){
        return billRepository.findById(id).orElse(null);
    }

    public void save(Bill bill){
        billRepository.save(bill);
    }

    public void changeType(Long id, BillType billType) {
        billRepository.updateMovieType(id, billType);
    }
}

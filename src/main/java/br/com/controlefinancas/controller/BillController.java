package br.com.controlefinancas.controller;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.repository.BillRepository;
import br.com.controlefinancas.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1")
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @GetMapping("/bills")
    public List<Bill> getAll(){
        return billService.list();
    }

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable(value = "id") Long id){
        Bill bill = billService.findById(id);
        return bill;
    }

    @PostMapping("/bills")
    public void create(@RequestBody Bill bill){
        billService.save(bill);
    }
}

package br.com.controlefinancas.controller;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import br.com.controlefinancas.entity.Owner;
import br.com.controlefinancas.service.BillService;
import br.com.controlefinancas.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BillController {

    private final BillService billService;
    private final OwnerService ownerService;

    @Autowired
    public BillController(BillService billService, OwnerService ownerService){
        this.billService = billService;
        this.ownerService = ownerService;
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

    @GetMapping("/bills/{owner}")
    public List<Bill> getBillByOwner(Owner owner){
        return billService.findByOwner(owner);
    }

    @PostMapping("/bills")
    public Bill create(@RequestBody Bill bill){
        return billService.save(bill);
    }

    @PutMapping("/bills/change/{id}")
    public void changeType(@PathVariable(value = "id") Long id, BillType billType){
        billService.changeType(id, billType);
    }

    @GetMapping("/bills/percentage/{ownerId}")
    public int getUsePercentageOfSalary(@PathVariable("ownerId") Long ownerId){
        Owner owner = ownerService.findById(ownerId);
        return billService.totalValuePercentage(owner);
    }
}

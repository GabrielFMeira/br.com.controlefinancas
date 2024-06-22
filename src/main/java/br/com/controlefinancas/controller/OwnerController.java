package br.com.controlefinancas.controller;

import br.com.controlefinancas.entity.Owner;
import br.com.controlefinancas.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @GetMapping("/owners")
    public List<Owner> getAll(){
        return ownerService.list();
    }

    @GetMapping("/owners/{id}")
    public Owner getOwnerById(@PathVariable(value = "id") Long id){
        Owner owner = ownerService.findById(id);
        return owner;
    }

    @PostMapping("/owners")
    public Owner postOwner(@RequestBody Owner owner){
        return ownerService.createOwner(owner);
    }
}

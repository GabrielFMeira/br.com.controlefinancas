package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Owner;
import br.com.controlefinancas.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository){
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> list(){
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

    public Owner findById(Long id){
        return ownerRepository.findById(id).orElse(null);
    }
}

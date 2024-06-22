package br.com.controlefinancas.service;

import br.com.controlefinancas.entity.Owner;

import java.util.List;

public interface OwnerService {

    public List<Owner> list();
    public Owner createOwner(Owner owner);
    public Owner findById(Long id);
}

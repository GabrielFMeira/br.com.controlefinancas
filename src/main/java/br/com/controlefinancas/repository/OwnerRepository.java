package br.com.controlefinancas.repository;

import br.com.controlefinancas.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}

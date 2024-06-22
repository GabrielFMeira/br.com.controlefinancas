package br.com.controlefinancas.repository;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.billType = :billType WHERE b.id = :id")
    public void updateMovieType(Long id, BillType billType);
}

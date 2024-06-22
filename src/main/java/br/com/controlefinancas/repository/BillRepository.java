package br.com.controlefinancas.repository;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Modifying
    @Query("UPDATE Bill b SET b.billType = :email WHERE b.id = id")
    public void updateMovieType( Long id, BillType billType);
}

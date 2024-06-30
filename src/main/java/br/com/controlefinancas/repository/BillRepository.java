package br.com.controlefinancas.repository;

import br.com.controlefinancas.entity.Bill;
import br.com.controlefinancas.entity.BillType;
import br.com.controlefinancas.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.billType = :billType WHERE b.id = :id")
    public void updateBillType(Long id, BillType billType);

    @Modifying
    @Transactional
    @Query("UPDATE Bill b SET b.billType = :billType WHERE b.billExpiring < :currentDay")
    public void updateBillExpiring(@Param("billType") BillType billType, @Param("currentDay") LocalDateTime currentDay);

    @Query("SELECT b FROM Bill b WHERE b.owner = :owner")
    List<Bill> findByOwner(@Param("owner") Owner owner);
}

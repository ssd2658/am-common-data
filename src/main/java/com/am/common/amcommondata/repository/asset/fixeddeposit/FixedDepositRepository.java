package com.am.common.amcommondata.repository.asset.fixeddeposit;

import com.am.common.amcommondata.domain.asset.fixeddeposit.FixedDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long> {
    List<FixedDeposit> findByBankName(String bankName);
    
    @Query("SELECT fd FROM FixedDeposit fd WHERE fd.depositInfo.interestRate >= :minRate")
    List<FixedDeposit> findByMinimumInterestRate(Double minRate);
    
    @Query("SELECT fd FROM FixedDeposit fd WHERE fd.depositInfo.maturityDate <= :date")
    List<FixedDeposit> findByMaturityDateBefore(LocalDateTime date);
    
    List<FixedDeposit> findByDepositInfoAutoRenewalTrue();
    
    @Query("SELECT fd FROM FixedDeposit fd WHERE fd.depositInfo.tenureInMonths >= :minTenure")
    List<FixedDeposit> findByMinimumTenure(Integer minTenure);
    
    List<FixedDeposit> findByIsTaxSavingTrue();
    
    @Query("SELECT DISTINCT fd.bankName FROM FixedDeposit fd")
    List<String> findAllBanks();
    
    @Query("SELECT fd FROM FixedDeposit fd WHERE fd.depositInfo.maturityAmount >= :minAmount")
    List<FixedDeposit> findByMinimumMaturityAmount(Double minAmount);
}

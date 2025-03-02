package com.am.common.amcommondata.repository.asset.mutualfund;

import com.am.common.amcommondata.domain.asset.mutualfund.MutualFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface MutualFundRepository extends JpaRepository<MutualFund, UUID> {
    List<MutualFund> findByFundInfoFundCategory(String category);
    
    List<MutualFund> findByFundInfoFundHouse(String fundHouse);
    
    @Query("SELECT mf FROM MutualFund mf WHERE mf.fundInfo.expenseRatio <= :maxExpenseRatio")
    List<MutualFund> findByMaxExpenseRatio(Double maxExpenseRatio);
    
    @Query("SELECT DISTINCT mf.fundInfo.fundHouse FROM MutualFund mf")
    List<String> findAllFundHouses();
    
    List<MutualFund> findByDirectPlanTrue();
    
    @Query("SELECT mf FROM MutualFund mf WHERE mf.fundInfo.aum >= :minAum")
    List<MutualFund> findByMinimumAUM(Double minAum);
}

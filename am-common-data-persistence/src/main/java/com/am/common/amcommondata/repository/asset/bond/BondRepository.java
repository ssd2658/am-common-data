package com.am.common.amcommondata.repository.asset.bond;

import com.am.common.amcommondata.domain.asset.bond.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface BondRepository extends JpaRepository<Bond, UUID> {
    List<Bond> findByBondInfoBondType(String bondType);
    
    List<Bond> findByBondInfoIssuer(String issuer);
    
    @Query("SELECT b FROM Bond b WHERE b.bondInfo.maturityDate <= :maturityDate")
    List<Bond> findByMaxMaturityDate(LocalDateTime maturityDate);
    
    @Query("SELECT b FROM Bond b WHERE b.bondInfo.couponRate >= :minRate")
    List<Bond> findByMinimumCouponRate(Double minRate);
    
    List<Bond> findByBondInfoCreditRating(String creditRating);
    
    @Query("SELECT b FROM Bond b WHERE b.bondInfo.yieldToMaturity >= :minYield")
    List<Bond> findByMinimumYTM(Double minYield);
    
    @Query("SELECT DISTINCT b.bondInfo.issuer FROM Bond b WHERE b.bondInfo.bondType = :bondType")
    List<String> findAllIssuersForBondType(String bondType);
}

package com.am.common.amcommondata.repository.asset.equity;

import com.am.common.amcommondata.domain.asset.equity.Equity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityRepository extends JpaRepository<Equity, UUID> {
    List<Equity> findBySector(String sector);
    List<Equity> findByIndustry(String industry);
    List<Equity> findByExchange(String exchange);
    List<Equity> findByMarketCapGreaterThan(Double marketCap);
    
    @Query("SELECT e FROM Equity e WHERE e.dividendYield >= :minYield")
    List<Equity> findHighDividendYieldStocks(Double minYield);
    
    @Query("SELECT e FROM Equity e WHERE e.peRatio BETWEEN :minPE AND :maxPE")
    List<Equity> findByPERatioRange(Double minPE, Double maxPE);
}

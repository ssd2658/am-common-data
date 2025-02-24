package com.am.common.amcommondata.repository.exchange;

import com.am.common.amcommondata.domain.exchange.MarketIndex;
import com.am.common.amcommondata.domain.exchange.IndexType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MarketIndexRepository extends JpaRepository<MarketIndex, Long> {
    Optional<MarketIndex> findByCode(String code);
    
    List<MarketIndex> findByExchangeCode(String exchangeCode);
    
    List<MarketIndex> findByIndexType(IndexType indexType);
    
    @Query("SELECT mi FROM MarketIndex mi LEFT JOIN FETCH mi.constituents WHERE mi.id = :id")
    Optional<MarketIndex> findByIdWithConstituents(Long id);
    
    List<MarketIndex> findByParentIndexId(Long parentIndexId);
    
    @Query("SELECT mi FROM MarketIndex mi WHERE mi.parentIndex IS NULL")
    List<MarketIndex> findAllParentIndices();
    
    @Query("SELECT DISTINCT mi.indexType FROM MarketIndex mi WHERE mi.exchange.code = :exchangeCode")
    List<IndexType> findIndexTypesByExchange(String exchangeCode);
}

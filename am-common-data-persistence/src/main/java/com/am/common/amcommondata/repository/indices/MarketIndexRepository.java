package com.am.common.amcommondata.repository.indices;

import com.am.common.amcommondata.domain.indices.MarketIndex;
import com.am.common.amcommondata.model.indices.IndexType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MarketIndexRepository extends JpaRepository<MarketIndex, UUID> {
    
    Optional<MarketIndex> findByCode(String code);
    
    List<MarketIndex> findByIndexType(IndexType indexType);
    
    @Query("SELECT mi FROM MarketIndex mi WHERE mi.active = true")
    List<MarketIndex> findAllActive();
    
    @Query("SELECT mi FROM MarketIndex mi WHERE mi.indexType = :type AND mi.active = true")
    List<MarketIndex> findActiveByType(@Param("type") IndexType type);
    
    @Query("SELECT DISTINCT mi FROM MarketIndex mi " +
           "JOIN mi.indexMemberships mem " +
           "WHERE (mem.equity.companyInfo.isin = :key OR mem.equity.companyInfo.symbol = :key) " +
           "AND mi.active = true")
    List<MarketIndex> findActiveIndicesByEquityKey(@Param("key") String key);
    
    @Query("SELECT DISTINCT mi FROM MarketIndex mi " +
           "JOIN mi.indexMemberships mem " +
           "WHERE (mem.equity.companyInfo.isin = :key OR mem.equity.companyInfo.symbol = :key) " +
           "AND mi.indexType = :type " +
           "AND mi.active = true")
    List<MarketIndex> findActiveIndicesByEquityKeyAndType(
        @Param("key") String key,
        @Param("type") IndexType type
    );
    
    boolean existsByCode(String code);
}

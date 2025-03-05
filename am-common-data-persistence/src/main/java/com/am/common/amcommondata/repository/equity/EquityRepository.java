package com.am.common.amcommondata.repository.equity;

import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EquityRepository extends JpaRepository<EquityInfo, UUID> {
    @Query("SELECT e FROM EquityInfo e WHERE " +
           "(:key IS NOT NULL AND (e.companyInfo.isin = :key OR e.companyInfo.symbol = :key))")
    Optional<EquityInfo> findByEquityKey(@Param("key") String key);
}
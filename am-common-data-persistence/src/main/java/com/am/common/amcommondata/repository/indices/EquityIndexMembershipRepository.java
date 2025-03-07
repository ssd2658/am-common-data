package com.am.common.amcommondata.repository.indices;

import com.am.common.amcommondata.domain.indices.EquityIndexMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityIndexMembershipRepository extends JpaRepository<EquityIndexMembership, UUID> {
    
    @Query("SELECT em FROM EquityIndexMembership em " +
           "WHERE em.equity.companyInfo.isin = :key OR em.equity.companyInfo.symbol = :key")
    List<EquityIndexMembership> findByEquityKey(@Param("key") String key);

    @Query("SELECT em FROM EquityIndexMembership em " +
           "WHERE em.index.code = :indexCode " +
           "AND (em.exitDate IS NULL OR em.exitDate >= :date) " +
           "AND em.entryDate <= :date")
    List<EquityIndexMembership> findActiveIndexMembers(
        @Param("indexCode") String indexCode,
        @Param("date") LocalDate date
    );

    @Query("SELECT em FROM EquityIndexMembership em " +
           "WHERE (em.equity.companyInfo.isin = :key OR em.equity.companyInfo.symbol = :key) " +
           "AND em.index.indexType = :indexType " +
           "AND (em.exitDate IS NULL OR em.exitDate >= :date) " +
           "AND em.entryDate <= :date")
    List<EquityIndexMembership> findActiveIndicesByTypeAndEquityKey(
        @Param("key") String key,
        @Param("indexType") String indexType,
        @Param("date") LocalDate date
    );
}

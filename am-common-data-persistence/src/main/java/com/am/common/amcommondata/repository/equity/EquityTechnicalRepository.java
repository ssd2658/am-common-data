package com.am.common.amcommondata.repository.equity;
import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import com.am.common.amcommondata.domain.asset.equity.EquityTechnical;
import com.am.common.amcommondata.domain.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityTechnicalRepository extends JpaRepository<EquityTechnical, UUID> {
    List<EquityTechnical> findByEquityId(UUID equityId);
    
    @Query("SELECT ef FROM EquityTechnical ef WHERE ef.equity.companyInfo.isin = :searchKey OR ef.equity.companyInfo.symbol = :searchKey")
    List<EquityTechnical> findByIsinOrSymbol(@Param("searchKey") String searchKey);
    
    @Query("SELECT ef FROM EquityTechnical ef WHERE " +
           "(ef.equity.companyInfo.isin = :searchKey OR ef.equity.companyInfo.symbol = :searchKey) " +
           "AND ef.auditInfo.dataDate BETWEEN :startDate AND :endDate")
    List<EquityTechnical> findByIsinOrSymbolAndDateRange(
        @Param("searchKey") String searchKey,
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );
    
    List<EquityTechnical> findByEquityIdAndAuditInfoDataDateBetween(
        UUID equityId, 
        LocalDate startDate, 
        LocalDate endDate
    );
}
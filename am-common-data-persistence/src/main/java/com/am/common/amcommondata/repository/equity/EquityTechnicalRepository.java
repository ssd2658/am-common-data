package com.am.common.amcommondata.repository.equity;
import com.am.common.amcommondata.domain.asset.equity.EquityTechnical;
import com.am.common.amcommondata.domain.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityTechnicalRepository extends JpaRepository<EquityTechnical, UUID> {
    List<EquityTechnical> findByIsin(String isin);
    List<EquityTechnical> findByPortfolio(Portfolio portfolio);
}
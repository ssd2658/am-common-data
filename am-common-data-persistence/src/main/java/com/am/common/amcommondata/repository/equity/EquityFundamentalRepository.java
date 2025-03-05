package com.am.common.amcommondata.repository.equity;
import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import com.am.common.amcommondata.domain.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityFundamentalRepository extends JpaRepository<EquityFundamental, UUID> {
    List<EquityFundamental> findByIsin(String isin);
    List<EquityFundamental> findByPortfolio(Portfolio portfolio);
}
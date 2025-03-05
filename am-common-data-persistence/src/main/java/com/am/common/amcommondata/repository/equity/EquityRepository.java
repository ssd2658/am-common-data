package com.am.common.amcommondata.repository.equity;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import com.am.common.amcommondata.domain.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface EquityRepository extends JpaRepository<EquityInfo, UUID> {
    List<Asset> findByIsin(String isin);
    List<Asset> findByPortfolio(Portfolio portfolio);
}
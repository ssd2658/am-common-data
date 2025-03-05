package com.am.common.amcommondata.service.equity;

import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EquityFundamentalService {
    EquityFundamental save(EquityFundamental fundamental);
    Optional<EquityFundamental> findById(UUID id);
    List<EquityFundamental> findByEquityId(UUID equityId);
    List<EquityFundamental> findByEquityIdAndDateRange(UUID equityId, LocalDate startDate, LocalDate endDate);
    void deleteById(UUID id);
}

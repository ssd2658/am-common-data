package com.am.common.amcommondata.service.equity;

import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EquityFundamentalService {
    EquityFundamental save(EquityFundamental fundamental);
    EquityFundamental saveWithEquityKey(String searchKey, EquityFundamental fundamental);
    Optional<EquityFundamental> findById(UUID id);
    List<EquityFundamental> findByEquityKey(String key);
    List<EquityFundamental> findByEquityKeyAndDateRange(String key, LocalDate startDate, LocalDate endDate);
    void deleteById(UUID id);
}

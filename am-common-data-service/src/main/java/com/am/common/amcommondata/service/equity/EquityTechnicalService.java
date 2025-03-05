package com.am.common.amcommondata.service.equity;


import com.am.common.amcommondata.domain.asset.equity.EquityTechnical;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EquityTechnicalService {
    EquityTechnical save(EquityTechnical technical);
    EquityTechnical saveWithEquityKey(String searchKey, EquityTechnical technical);
    Optional<EquityTechnical> findById(UUID id);
    List<EquityTechnical> findByEquityKey(String key);
    List<EquityTechnical> findByEquityKeyAndDateRange(String key, LocalDate startDate, LocalDate endDate);
    void deleteById(UUID id);
}

package com.am.common.amcommondata.service.equity;

import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import java.util.Optional;
import java.util.UUID;

public interface EquityService {
    EquityInfo save(EquityInfo equity);
    Optional<EquityInfo> findById(UUID id);
    Optional<EquityInfo> findByEquityKey(String key);
    void deleteById(UUID id);
}

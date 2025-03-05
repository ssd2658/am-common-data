package com.am.common.amcommondata.service.equity.impl;

import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import com.am.common.amcommondata.repository.equity.EquityRepository;
import com.am.common.amcommondata.service.equity.EquityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquityServiceImpl implements EquityService {
    
    private final EquityRepository equityRepository;

    @Override
    @Transactional
    public EquityInfo save(EquityInfo equity) {
        return equityRepository.save(equity);
    }

    @Override
    public Optional<EquityInfo> findById(UUID id) {
        return equityRepository.findById(id);
    }

    @Override
    public Optional<EquityInfo> findByIsin(String isin) {
        return equityRepository.findByCompanyInfoIsin(isin);
    }

    @Override
    public Optional<EquityInfo> findBySymbol(String symbol) {
        return equityRepository.findByCompanyInfoSymbol(symbol);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        equityRepository.deleteById(id);
    }
}

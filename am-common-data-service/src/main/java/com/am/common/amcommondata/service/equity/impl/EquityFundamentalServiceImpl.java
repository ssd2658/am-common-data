package com.am.common.amcommondata.service.equity.impl;

import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import com.am.common.amcommondata.repository.equity.EquityFundamentalRepository;
import com.am.common.amcommondata.service.equity.EquityFundamentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquityFundamentalServiceImpl implements EquityFundamentalService {
    
    private final EquityFundamentalRepository fundamentalRepository;

    @Override
    @Transactional
    public EquityFundamental save(EquityFundamental fundamental) {
        return fundamentalRepository.save(fundamental);
    }

    @Override
    public Optional<EquityFundamental> findById(UUID id) {
        return fundamentalRepository.findById(id);
    }

    @Override
    public List<EquityFundamental> findByEquityId(UUID equityId) {
        return fundamentalRepository.findByEquityId(equityId);
    }

    @Override
    public List<EquityFundamental> findByEquityIdAndDateRange(UUID equityId, LocalDate startDate, LocalDate endDate) {
        return fundamentalRepository.findByEquityIdAndAuditInfoDataDateBetween(equityId, startDate, endDate);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        fundamentalRepository.deleteById(id);
    }
}

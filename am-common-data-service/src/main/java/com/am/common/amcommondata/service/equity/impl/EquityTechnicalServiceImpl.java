package com.am.common.amcommondata.service.equity.impl;

import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import com.am.common.amcommondata.domain.asset.equity.EquityTechnical;
import com.am.common.amcommondata.repository.equity.EquityTechnicalRepository;
import com.am.common.amcommondata.service.equity.EquityService;
import com.am.common.amcommondata.service.equity.EquityTechnicalService;
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
public class EquityTechnicalServiceImpl implements EquityTechnicalService {
    
    private final EquityTechnicalRepository technicalRepository;
    private final EquityService equityService;

    @Override
    @Transactional
    public EquityTechnical saveWithEquityKey(String key, EquityTechnical technical) {
        EquityInfo equity = equityService.findByEquityKey(key)
            .orElseThrow(() -> new IllegalArgumentException("No equity found with search key (ISIN/Symbol): " + key));
        technical.setEquity(equity);
        return technicalRepository.save(technical);
    }

    @Override
    public Optional<EquityTechnical> findById(UUID id) {
        return technicalRepository.findById(id);
    }

    @Override
    public List<EquityTechnical> findByEquityKey(String key) {
        return technicalRepository.findByIsinOrSymbol(key);
    }

    @Override
    public List<EquityTechnical> findByEquityKeyAndDateRange(String searchKey, LocalDate startDate, LocalDate endDate) {
        return technicalRepository.findByIsinOrSymbolAndDateRange(searchKey, startDate, endDate);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        technicalRepository.deleteById(id);
    }

    @Override
    public EquityTechnical save(EquityTechnical technical) {
        EquityInfo equity = equityService.findByEquityKey(technical.getEquity().getCompanyInfo().getIsin())
            .orElseThrow(() -> new IllegalArgumentException("No equity found with search key (ISIN/Symbol): " + technical.getEquity().getCompanyInfo().getIsin()));
        technical.setEquity(equity);
        return technicalRepository.save(technical);
    }
}

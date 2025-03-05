package com.am.common.amcommondata.service.equity.impl;

import com.am.common.amcommondata.domain.asset.equity.EquityFundamental;
import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import com.am.common.amcommondata.repository.equity.EquityFundamentalRepository;
import com.am.common.amcommondata.service.equity.EquityFundamentalService;
import com.am.common.amcommondata.service.equity.EquityService;

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
    private final EquityService equityService;

    @Override
    @Transactional
    public EquityFundamental save(EquityFundamental fundamental) {
        return fundamentalRepository.save(fundamental);
    }

    @Override
    @Transactional
    public EquityFundamental saveWithEquityKey(String key, EquityFundamental fundamental) {
        EquityInfo equity = equityService.findByEquityKey(key)
            .orElseThrow(() -> new IllegalArgumentException("No equity found with search key (ISIN/Symbol): " + key));
        fundamental.setEquity(equity);
        return fundamentalRepository.save(fundamental);
    }

    @Override
    public Optional<EquityFundamental> findById(UUID id) {
        return fundamentalRepository.findById(id);
    }

    @Override
    public List<EquityFundamental> findByEquityKey(String searchKey) {
        return fundamentalRepository.findByIsinOrSymbol(searchKey);
    }

    @Override
    public List<EquityFundamental> findByEquityKeyAndDateRange(String searchKey, LocalDate startDate, LocalDate endDate) {
        return fundamentalRepository.findByIsinOrSymbolAndDateRange(searchKey, startDate, endDate);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        fundamentalRepository.deleteById(id);
    }
}

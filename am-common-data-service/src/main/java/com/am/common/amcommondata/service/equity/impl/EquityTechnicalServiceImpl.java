package com.am.common.amcommondata.service.equity.impl;

import com.am.common.amcommondata.domain.asset.equity.EquityTechnical;
import com.am.common.amcommondata.repository.equity.EquityTechnicalRepository;
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

    @Override
    @Transactional
    public EquityTechnical save(EquityTechnical technical) {
        return technicalRepository.save(technical);
    }

    @Override
    public Optional<EquityTechnical> findById(UUID id) {
        return technicalRepository.findById(id);
    }

    @Override
    public List<EquityTechnical> findByEquityId(UUID equityId) {
        return technicalRepository.findByEquityId(equityId);
    }

    @Override
    public List<EquityTechnical> findByEquityIdAndDateRange(UUID equityId, LocalDate startDate, LocalDate endDate) {
        return technicalRepository.findByEquityIdAndAuditInfoDataDateBetween(equityId, startDate, endDate);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        technicalRepository.deleteById(id);
    }
}

package com.am.common.amcommondata.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.am.common.amcommondata.document.security.SecurityDocument;
import com.am.common.amcommondata.mapper.SecurityModelMapper;
import com.am.common.amcommondata.model.security.SecurityModel;
import com.am.common.amcommondata.repository.security.SecurityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityService {
    
    private final SecurityRepository securityRepository;
    private final SecurityModelMapper securityMapper;
    private final AuditService auditService;

    public SecurityModel save(SecurityModel securityModel) {
        SecurityDocument document = securityMapper.toDocument(securityModel);
        auditService.updateAudit(document);
        return securityMapper.toModel(securityRepository.save(document));
    }

    public Optional<SecurityModel> findById(UUID id) {
        return securityRepository.findById(id)
                .map(securityMapper::toModel);
    }

    public Optional<SecurityModel> findBySymbol(String symbol) {
        return securityRepository.findBySymbol(symbol)
                .map(securityMapper::toModel);
    }

    public Optional<SecurityModel> findByIsin(String isin) {
        return securityRepository.findByIsin(isin)
                .map(securityMapper::toModel);
    }

    public List<SecurityModel> findActiveLargeCapsByMinMarketCapAndSector(Long minMarketCap, String sector) {
        return securityRepository.findActiveLargeCapsByMinMarketCapAndSector(minMarketCap, sector)
                .stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<SecurityModel> findAllVersionsById(UUID id) {
        return securityRepository.findAllVersionsById(id)
                .stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        securityRepository.deleteById(id);
    }

    public void deleteAll() {
        securityRepository.deleteAll();
    }

    public List<SecurityModel> saveAll(List<SecurityModel> securities) {
        List<SecurityDocument> documents = securities.stream()
                .map(securityMapper::toDocument)
                .peek(auditService::updateAudit)
                .collect(Collectors.toList());
        
        return securityRepository.saveAll(documents)
                .stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }
}

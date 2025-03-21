package com.am.common.amcommondata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.mongodb.core.MongoTemplate;
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
    private final MongoTemplate mongoTemplate;

    public SecurityModel save(SecurityModel securityModel) {
        SecurityDocument document = securityMapper.toDocument(securityModel);
        auditService.updateAudit(document);
        return securityMapper.toModel(mongoTemplate.save(document));
    }

    public Optional<SecurityModel> findById(UUID id) {
        return securityRepository.findById(id.toString())
                .map(securityMapper::toModel);
    }

    public Optional<SecurityModel> findBySymbol(String symbol) {
        return securityRepository.findBySymbol(symbol).stream()
                .findFirst()
                .map(securityMapper::toModel);
    }

    public Optional<SecurityModel> findByKey(String key) {
        return securityRepository.findByKey(key).stream()
                .findFirst()
                .map(securityMapper::toModel);
    }

    public Optional<SecurityModel> findByIsin(String isin) {
        return securityRepository.findByIsin(isin).stream()
                .findFirst()
                .map(securityMapper::toModel);
    }

    public List<SecurityModel> findActiveLargeCapsByMinMarketCapAndSector(Long minMarketCap, String sector) {
        return securityRepository.findActiveLargeCapsByMinMarketCapAndSector(minMarketCap, sector)
                .stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<SecurityModel> findAllVersionsById(UUID id) {
        return securityRepository.findAllVersionsById(id.toString())
                .stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID id) {
        securityRepository.deleteById(id.toString());
    }

    public void deleteAll() {
        securityRepository.deleteAll();
    }

    public List<SecurityModel> saveAll(List<SecurityModel> securities) {
        List<SecurityDocument> documents = securities.stream()
                .map(securityMapper::toDocument)
                .peek(auditService::updateAudit)
                .collect(Collectors.toList());
        
        List<SecurityDocument> savedDocuments = new ArrayList<>();
        for (int i = 0; i < documents.size(); i += 100) {
            int end = Math.min(i + 100, documents.size());
            List<SecurityDocument> batch = documents.subList(i, end);
            savedDocuments.addAll(mongoTemplate.insertAll(batch));
        }
        
        return savedDocuments.stream()
                .map(securityMapper::toModel)
                .collect(Collectors.toList());
    }
}

package com.am.common.amcommondata.repository.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.am.common.amcommondata.document.security.SecurityDocument;
import com.am.common.amcommondata.repository.base.BaseRepository;

@Repository
public interface SecurityRepository extends BaseRepository<SecurityDocument> {
    
    @Query(value = "{'key.symbol': ?0}", sort = "{'audit.createdAt': -1}")
    Optional<SecurityDocument> findBySymbol(String symbol);
    
    @Query(value = "{'key.isin': ?0}", sort = "{'audit.createdAt': -1}")
    Optional<SecurityDocument> findByIsin(String isin);
    
    @Query(value = "{$or: [{'key.isin': ?0}, {'key.symbol': ?0}]}", sort = "{'audit.createdAt': -1}")
    Optional<SecurityDocument> findByKey(String key);
    
    @Query(value = "{'metadata.sector': ?0}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findBySector(String sector);
    
    @Query(value = "{'metadata.industry': ?0}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findByIndustry(String industry);
    
    @Query(value = "{'metadata.marketCapType': ?0}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findByMarketCapType(String marketCapType);
    
    @Query(value = "{'metadata.marketCapValue': {$gte: ?0}}", sort = "{'metadata.marketCapValue': -1}")
    List<SecurityDocument> findByMinMarketCap(Long minMarketCap);
    
    @Query(value = "{'metadata.exchange': ?0}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findByExchange(String exchange);
    
    @Query(value = "{'metadata.tradingStatus': ?0}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findByTradingStatus(String tradingStatus);
    
    @Query(value = "{'companyInfo.legalName': {$regex: ?0, $options: 'i'}}", sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findByCompanyNamePattern(String namePattern);
    
    @Query(value = "{$and: [{'metadata.marketCapValue': {$gte: ?0}}, {'metadata.sector': ?1}, {'metadata.tradingStatus': 'ACTIVE'}]}", 
           sort = "{'audit.createdAt': -1}")
    List<SecurityDocument> findActiveLargeCapsByMinMarketCapAndSector(Long minMarketCap, String sector);
}

package com.am.common.amcommondata.repository;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, UUID> {
    List<Portfolio> findByCreatedBy(String createdBy);
    
    @Query("SELECT p FROM Portfolio p LEFT JOIN FETCH p.assets WHERE p.id = :id")
    Portfolio findByIdWithAssets(UUID id);
    
    List<Portfolio> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT p FROM Portfolio p WHERE p.assets.size > :minAssets")
    List<Portfolio> findPortfoliosWithMinimumAssets(int minAssets);
}

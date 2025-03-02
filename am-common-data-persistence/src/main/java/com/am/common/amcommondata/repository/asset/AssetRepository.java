package com.am.common.amcommondata.repository.asset;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.enums.AssetType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {
    List<Asset> findByAssetType(AssetType assetType);
    
    List<Asset> findByPortfolioId(UUID portfolioId);
    
    @Query("SELECT a FROM Asset a WHERE a.marketData.marketCap >= :minMarketCap")
    List<Asset> findByMinimumMarketCap(Double minMarketCap);
    
    @Query("SELECT DISTINCT a.assetType FROM Asset a")
    List<AssetType> findAllAssetTypes();
    
    @Query("SELECT a FROM Asset a WHERE TYPE(a) = :assetClass")
    List<Asset> findByAssetClass(Class<?> assetClass);
}

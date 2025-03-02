package com.am.common.amcommondata.repository.asset.commodity;

import com.am.common.amcommondata.domain.asset.commodity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity, UUID> {
    List<Commodity> findByCommodityType(String type);
    List<Commodity> findByForm(String form);
    List<Commodity> findByStorageLocation(String location);
    
    @Query("SELECT c FROM Commodity c WHERE c.weight >= :minWeight AND c.weightUnit = :unit")
    List<Commodity> findByMinimumWeight(Double minWeight, String unit);
    
    @Query("SELECT c FROM Commodity c WHERE c.purity >= :minPurity")
    List<Commodity> findByMinimumPurity(Double minPurity);
    
    @Query("SELECT c FROM Commodity c WHERE c.form = 'Physical' AND c.storageLocation = :location")
    List<Commodity> findPhysicalCommoditiesByLocation(String location);
}

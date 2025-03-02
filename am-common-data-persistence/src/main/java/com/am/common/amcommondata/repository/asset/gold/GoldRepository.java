package com.am.common.amcommondata.repository.asset.gold;

import com.am.common.amcommondata.domain.asset.gold.Gold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface GoldRepository extends JpaRepository<Gold, UUID> {
    List<Gold> findByGoldInfoForm(String form);
    
    @Query("SELECT g FROM Gold g WHERE g.goldInfo.purity >= :minPurity")
    List<Gold> findByMinimumPurity(Double minPurity);
    
    List<Gold> findByGoldInfoManufacturer(String manufacturer);
    
    List<Gold> findByGoldInfoIsInsuredTrue();
    
    @Query("SELECT g FROM Gold g WHERE g.goldInfo.weightInGrams >= :minWeight")
    List<Gold> findByMinimumWeight(Double minWeight);
    
    @Query("SELECT DISTINCT g.goldInfo.form FROM Gold g")
    List<String> findAllGoldForms();
    
    List<Gold> findByGoldInfoHallmarkCertificateNumberIsNotNull();
}

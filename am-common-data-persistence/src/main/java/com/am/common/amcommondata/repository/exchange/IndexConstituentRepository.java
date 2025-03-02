package com.am.common.amcommondata.repository.exchange;

import com.am.common.amcommondata.domain.exchange.IndexConstituent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IndexConstituentRepository extends JpaRepository<IndexConstituent, Long> {
    List<IndexConstituent> findByIndexId(Long indexId);
    
    List<IndexConstituent> findByAssetId(Long assetId);
    
    @Query("SELECT ic FROM IndexConstituent ic WHERE ic.index.code = :indexCode ORDER BY ic.weightPercentage DESC")
    List<IndexConstituent> findByIndexCodeOrderByWeightDesc(String indexCode);
    
    @Query("SELECT ic FROM IndexConstituent ic WHERE ic.index.id = :indexId AND ic.weightPercentage >= :minWeight")
    List<IndexConstituent> findHeavyweightConstituents(Long indexId, Double minWeight);
    
    List<IndexConstituent> findByInclusionDateAfter(LocalDateTime date);
    
    @Query("SELECT ic FROM IndexConstituent ic WHERE ic.index.id = :indexId AND ic.lastRebalancingDate = " +
           "(SELECT MAX(ic2.lastRebalancingDate) FROM IndexConstituent ic2 WHERE ic2.index.id = :indexId)")
    List<IndexConstituent> findLatestIndexComposition(Long indexId);
}

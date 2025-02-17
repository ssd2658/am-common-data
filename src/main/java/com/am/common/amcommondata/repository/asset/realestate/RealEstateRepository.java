package com.am.common.amcommondata.repository.asset.realestate;

import com.am.common.amcommondata.domain.asset.realestate.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
    List<RealEstate> findByPropertyType(String propertyType);
    List<RealEstate> findByLocation(String location);
    List<RealEstate> findByOccupancyStatus(String status);
    
    @Query("SELECT r FROM RealEstate r WHERE r.rentalIncome > 0")
    List<RealEstate> findRentGeneratingProperties();
    
    @Query("SELECT r FROM RealEstate r WHERE r.currentValuation >= :minValue")
    List<RealEstate> findHighValueProperties(Double minValue);
    
    @Query("SELECT r FROM RealEstate r WHERE r.area >= :minArea AND r.areaUnit = :unit")
    List<RealEstate> findByMinimumArea(Double minArea, String unit);
}

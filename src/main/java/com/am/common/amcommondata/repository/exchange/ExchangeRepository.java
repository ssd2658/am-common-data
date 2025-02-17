package com.am.common.amcommondata.repository.exchange;

import com.am.common.amcommondata.domain.exchange.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Optional<Exchange> findByCode(String code);
    
    List<Exchange> findByCountry(String country);
    
    @Query("SELECT e FROM Exchange e LEFT JOIN FETCH e.indices WHERE e.id = :id")
    Optional<Exchange> findByIdWithIndices(Long id);
    
    List<Exchange> findByActiveTrue();
    
    @Query("SELECT DISTINCT e.country FROM Exchange e")
    List<String> findAllCountries();
}

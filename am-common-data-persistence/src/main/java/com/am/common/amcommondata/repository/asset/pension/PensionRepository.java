package com.am.common.amcommondata.repository.asset.pension;

import com.am.common.amcommondata.domain.asset.pension.NPS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.time.LocalDate;

@Repository
public interface PensionRepository extends JpaRepository<NPS, Long> {
    List<NPS> findBySchemeType(String schemeType);
    List<NPS> findByFundManager(String fundManager);
    List<NPS> findByMaturityDateBefore(LocalDate date);
    
    @Query("SELECT p FROM NPS p WHERE p.currentReturn >= :minReturn")
    List<NPS> findHighPerformingSchemes(Double minReturn);
    
    @Query("SELECT p FROM NPS p WHERE p.employeeContribution + p.employerContribution + p.governmentContribution >= :minContribution")
    List<NPS> findByMinimumTotalContribution(Double minContribution);
    
    @Query("SELECT p FROM NPS p WHERE p.expectedCorpus >= :minCorpus")
    List<NPS> findByMinimumExpectedCorpus(Double minCorpus);
}

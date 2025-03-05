package com.am.common.amcommondata.domain.asset.equity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.am.common.amcommondata.domain.asset.equity.embedded.CompanyInfo;

import com.am.common.amcommondata.domain.common.AuditInfo;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equity_info")
public class EquityInfo {
    @Id
    private UUID id;

    @Embedded
    private CompanyInfo companyInfo;

    // Relationships
    @OneToMany(mappedBy = "equity", cascade = CascadeType.ALL)
    private List<EquityFundamental> fundamentalData;

    @OneToMany(mappedBy = "equity", cascade = CascadeType.ALL)
    private List<EquityTechnical> technicalData;

    @Embedded
    private AuditInfo auditInfo;
}

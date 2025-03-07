package com.am.common.amcommondata.domain.indices;

import com.am.common.amcommondata.domain.asset.equity.EquityInfo;
import com.am.common.amcommondata.domain.common.AuditInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equity_index_membership")
public class EquityIndexMembership {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equity_id", nullable = false)
    private EquityInfo equity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "index_id", nullable = false)
    private MarketIndex index;

    @Column(name = "entry_date", nullable = false)
    private LocalDate entryDate;

    @Column(name = "exit_date")
    private LocalDate exitDate;

    @Column(name = "weight")
    private Double weight;

    @Embedded
    private AuditInfo auditInfo;

    @PrePersist
    @PreUpdate
    private void updateAudit() {
        if (auditInfo == null) {
            auditInfo = new AuditInfo();
        }
        auditInfo.setDataDate(LocalDate.now());
    }
}

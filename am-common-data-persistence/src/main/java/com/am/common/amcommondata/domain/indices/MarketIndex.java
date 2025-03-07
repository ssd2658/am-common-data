package com.am.common.amcommondata.domain.indices;

import com.am.common.amcommondata.model.indices.IndexType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

import com.am.common.amcommondata.domain.common.AuditInfo;
import com.am.common.amcommondata.domain.common.OHLCV;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "market_index")
public class MarketIndex {
    @Id
    private UUID id;

    @Column(name = "index_code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "index_type", nullable = false)
    private IndexType indexType;

    @Embedded
    private OHLCV ohlcv;

    @Column(name = "is_active", nullable = false)
    private boolean active;

    @Embedded
    private AuditInfo auditInfo;

    @OneToMany(mappedBy = "index", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EquityIndexMembership> indexMemberships;
}

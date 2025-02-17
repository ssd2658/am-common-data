package com.am.common.amcommondata.domain.exchange;

import com.am.common.amcommondata.domain.asset.Asset;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "index_constituents")
public class IndexConstituent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "index_id", nullable = false)
    private MarketIndex index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_id", nullable = false)
    private Asset asset;

    @Column(name = "weight_percentage", nullable = false)
    private Double weightPercentage;

    @Column(name = "free_float_factor")
    private Double freeFloatFactor;

    @Column(name = "inclusion_date")
    private LocalDateTime inclusionDate;

    @Column(name = "last_rebalancing_date")
    private LocalDateTime lastRebalancingDate;

    private Boolean active = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Version
    private Long version;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

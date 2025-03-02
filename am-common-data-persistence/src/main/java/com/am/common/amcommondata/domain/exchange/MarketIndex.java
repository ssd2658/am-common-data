package com.am.common.amcommondata.domain.exchange;

import com.am.common.amcommondata.domain.common.MarketData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "market_indices")
public class MarketIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String code; // NIFTY50, BANKNIFTY, etc.

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exchange_id", nullable = false)
    private Exchange exchange;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_index_id")
    private MarketIndex parentIndex;

    @OneToMany(mappedBy = "parentIndex", cascade = CascadeType.ALL)
    private Set<MarketIndex> subIndices = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "index_type")
    private IndexType indexType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "market_data_id")
    private MarketData marketData;

    @OneToMany(mappedBy = "index", cascade = CascadeType.ALL)
    private Set<IndexConstituent> constituents = new HashSet<>();

    private Double baseValue;
    
    @Column(name = "base_date")
    private LocalDateTime baseDate;
    
    @Column(name = "calculation_frequency")
    private String calculationFrequency; // Real-time, End of Day
    
    @Column(name = "rebalancing_frequency")
    private String rebalancingFrequency; // Monthly, Quarterly, Semi-Annual, Annual

    private String methodology;
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

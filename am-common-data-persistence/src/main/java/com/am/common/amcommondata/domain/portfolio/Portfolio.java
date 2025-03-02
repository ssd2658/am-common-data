package com.am.common.amcommondata.domain.portfolio;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.enums.FundType;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;
    private String owner;
    private String currency;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "fund_type", nullable = false)
    private FundType fundType;
    private String status;
    private String tags;
    private String notes;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Asset> assets = new HashSet<>();

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    
    @Version
    private Long version;

    public void addAsset(Asset asset) {
        assets.add(asset);
        asset.setPortfolio(this);
    }

    public void removeAsset(Asset asset) {
        assets.remove(asset);
        asset.setPortfolio(null);
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Double getCurrentValue() {
        if (assets == null || assets.isEmpty()) {
            return 0.0;
        }
        return assets.stream()
                .filter(asset -> asset.getCurrentValue() != null)
                .mapToDouble(Asset::getCurrentValue)
                .sum();
    }
}
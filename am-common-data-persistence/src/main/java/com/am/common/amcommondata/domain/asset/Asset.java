package com.am.common.amcommondata.domain.asset;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import com.am.common.amcommondata.model.enums.AssetType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "assets")
public abstract class Asset {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String symbol;

    private String isin;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @Enumerated(EnumType.STRING)
    @Column(name = "asset_type", nullable = false)
    private AssetType assetType;

    private Double quantity;
    private Double avgBuyingPrice;
    private Double currentValue;
    private Double investmentValue;
    private String buyingPlatform;
    private String broker;
    private String exchange;
    private String sector;
    private String industry;
    private String currency;
    private String country;
    private String tags;
    private String notes;
    private String status;
    private LocalDateTime purchaseDate;
    private LocalDateTime lastUpdated;
    private LocalDateTime maturityDate;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        modifiedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = LocalDateTime.now();
    }
}

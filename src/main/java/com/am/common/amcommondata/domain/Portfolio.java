package com.am.common.amcommondata.domain;

import com.am.common.amcommondata.domain.asset.Asset;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Asset> assets = new HashSet<>();

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
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
}

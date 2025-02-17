package com.am.common.amcommondata.domain.exchange;

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
@Table(name = "exchanges")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code; // NSE, BSE, NYSE etc.

    @Column(nullable = false)
    private String name;

    private String description;
    private String country;
    private String timezone;
    private String currency;
    private String website;

    @OneToMany(mappedBy = "exchange", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MarketIndex> indices = new HashSet<>();

    @Column(name = "trading_hours")
    private String tradingHours;

    @Column(name = "clearing_house")
    private String clearingHouse;

    @Column(name = "regulatory_body")
    private String regulatoryBody;

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

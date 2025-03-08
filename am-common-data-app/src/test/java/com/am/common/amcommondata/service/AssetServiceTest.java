package com.am.common.amcommondata.service;

import com.am.common.amcommondata.config.TestConfig;
import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.enums.AssetType;
import com.am.common.amcommondata.model.enums.BrokerType;
import com.am.common.amcommondata.repository.portfolio.AssetRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
@Transactional
class AssetServiceTest {

    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        // Create test assets with different ISINs
        createTestAsset("US0378331005", "AAPL", AssetType.EQUITY);
        createTestAsset("US0378331005", "AAPL", AssetType.EQUITY); // Duplicate ISIN
        createTestAsset("US88160R1014", "TSLA", AssetType.EQUITY);
        createTestAsset("US02079K1079", "GOOGL", AssetType.EQUITY);
        
        // Flush to ensure all entities are persisted
        entityManager.flush();
        entityManager.clear();
    }

    @Test
    void findDistinctIsins_ShouldReturnUniqueIsins() {
        // When
        List<String> distinctIsins = assetService.findDistinctIsins();

        // Then
        assertThat(distinctIsins)
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        "US0378331005",
                        "US88160R1014",
                        "US02079K1079"
                );
    }

    private Asset createTestAsset(String isin, String symbol, AssetType assetType) {
        Asset asset = Asset.builder()
                .isin(isin)
                .symbol(symbol)
                .assetType(assetType)
                .brokerType(BrokerType.ZERODHA)
                .build();
        return assetRepository.save(asset);
    }
}

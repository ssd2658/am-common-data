package com.am.common.amcommondata.service;

import com.am.common.amcommondata.config.TestConfig;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.model.enums.FundType;
import com.am.common.amcommondata.repository.portfolio.PortfolioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
@Testcontainers
public class PortfolioServiceContainerTest {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioRepository portfolioRepository;

    private PortfolioModel testPortfolio;

    @BeforeEach
    void setUp() {
        portfolioRepository.deleteAll();
        
        Set<String> assetTypes = new HashSet<>();
        assetTypes.add("BOND");
        assetTypes.add("STOCK");
        
        testPortfolio = PortfolioModel.builder()
                .name("Test Portfolio")
                .description("Test Portfolio Description")
                .assets(new HashSet<>())
                .owner("test-user")
                .fundType(FundType.DEFAULT)
                //.assetTypes(assetTypes)
                .totalValue(100000.0)
                .assetCount(0)
                .status("ACTIVE")
                .createdBy("test-user")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    void shouldCreatePortfolio() {
        PortfolioModel created = portfolioService.createPortfolio(testPortfolio);
        
        assertNotNull(created.getId());
        assertEquals(testPortfolio.getName(), created.getName());
        assertEquals(testPortfolio.getDescription(), created.getDescription());
        assertEquals(testPortfolio.getCreatedBy(), created.getCreatedBy());
        //assertEquals(testPortfolio.getAssetTypes(), created.getAssetTypes());
    }

    @Test
    void shouldGetPortfolio() {
        PortfolioModel created = portfolioService.createPortfolio(testPortfolio);
        PortfolioModel found = portfolioService.getPortfolioById(created.getId());
        
        assertEquals(created.getId(), found.getId());
        assertEquals(created.getName(), found.getName());
        assertEquals(created.getDescription(), found.getDescription());
        assertEquals(created.getCreatedBy(), found.getCreatedBy());
    }

    @Test
    void shouldGetAllPortfolios() {
        portfolioService.createPortfolio(testPortfolio);
        
        PortfolioModel secondPortfolio = PortfolioModel.builder()
                .name("Second Portfolio")
                .description("Second Portfolio Description")
                .assets(new HashSet<>())
                .owner("test-user")
                .fundType(FundType.EQUITY_LARGE_CAP)
                //.assetTypes(new HashSet<>())
                .totalValue(200000.0)
                .assetCount(0)
                .status("ACTIVE")
                .createdBy("test-user")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        portfolioService.createPortfolio(secondPortfolio);

        List<PortfolioModel> portfolios = portfolioService.getPortfoliosByUserId("test-user");
        assertEquals(2, portfolios.size());
    }

    @Test
    void shouldGetPortfoliosByUser() {
        portfolioService.createPortfolio(testPortfolio);
        
        List<PortfolioModel> portfolios = portfolioService.getPortfoliosByUserId("test-user");
        assertFalse(portfolios.isEmpty());
        assertEquals("test-user", portfolios.get(0).getCreatedBy());
    }

    @Test
    void shouldUpdatePortfolio() {
        PortfolioModel created = portfolioService.createPortfolio(testPortfolio);
        created.setName("Updated Portfolio");
        created.setDescription("Updated Description");
        
        PortfolioModel updated = portfolioService.updatePortfolio(created.getId(), created);
        assertEquals("Updated Portfolio", updated.getName());
        assertEquals("Updated Description", updated.getDescription());
    }

    @Test
    void shouldDeletePortfolio() {
        PortfolioModel created = portfolioService.createPortfolio(testPortfolio);
        portfolioService.deletePortfolio(created.getId());
        
        assertTrue(portfolioRepository.findById(created.getId()).isEmpty());
    }
}

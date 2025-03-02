package com.am.common.amcommondata.service;

import com.am.common.amcommondata.config.TestConfig;
import com.am.common.amcommondata.domain.asset.bond.Bond;
import com.am.common.amcommondata.domain.common.BondInfo;
import com.am.common.amcommondata.model.asset.bond.BondModel;
import com.am.common.amcommondata.model.enums.AssetType;
import com.am.common.amcommondata.model.enums.BrokerType;
import com.am.common.amcommondata.repository.asset.bond.BondRepository;
import com.am.common.amcommondata.service.asset.BondService;
import com.am.common.amcommondata.service.mapper.asset.BondMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = TestConfig.class)
@Testcontainers
public class BondServiceContainerTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.2")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private BondService bondService;

    @Autowired
    private BondRepository bondRepository;

    @Autowired
    private BondMapper bondMapper;

    private BondModel testBond;

    @BeforeEach
    void setUp() {
        bondRepository.deleteAll();
        
        testBond = BondModel.builder()
                .name("Test Bond")
                .symbol("TESTBOND")
                .description("Test Government Bond")
                .assetType(AssetType.BOND)
                .brokerType(BrokerType.DIRECT)
                .quantity(100.0)
                .avgBuyingPrice(1000.0)
                .currentValue(1050.0)
                .investmentValue(100000.0)
                .bondType("Government")
                .issuer("Test Issuer")
                .faceValue(1000.0)
                .couponRate(5.5)
                .couponFrequency("Semi-Annual")
                .creditRating("AAA")
                .yieldToMaturity(6.0)
                .isCallable(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isActive(true)
                .build();
    }

    @Test
    void shouldCreateBond() {
        BondModel created = bondService.createBond(testBond);
        
        assertNotNull(created.getId());
        assertEquals(testBond.getName(), created.getName());
        assertEquals(testBond.getBondType(), created.getBondType());
        assertEquals(testBond.getIssuer(), created.getIssuer());
    }

    @Test
    void shouldGetBond() {
        BondModel created = bondService.createBond(testBond);
        BondModel found = bondService.getBond(created.getId());
        
        assertEquals(created.getId(), found.getId());
        assertEquals(created.getBondType(), found.getBondType());
        assertEquals(created.getIssuer(), found.getIssuer());
    }

    @Test
    void shouldGetAllBonds() {
        bondService.createBond(testBond);
        
        BondModel secondBond = BondModel.builder()
                .name("Second Bond")
                .symbol("BOND2")
                .description("Second Test Bond")
                .assetType(AssetType.BOND)
                .brokerType(BrokerType.DIRECT)
                .quantity(200.0)
                .avgBuyingPrice(2000.0)
                .currentValue(2100.0)
                .investmentValue(420000.0)
                .bondType("Corporate")
                .issuer("Second Issuer")
                .faceValue(2000.0)
                .couponRate(6.5)
                .couponFrequency("Annual")
                .creditRating("AA")
                .yieldToMaturity(7.0)
                .isCallable(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .isActive(true)
                .build();
        bondService.createBond(secondBond);

        List<BondModel> bonds = bondService.getAllBonds();
        assertEquals(2, bonds.size());
    }

    @Test
    void shouldGetBondsByType() {
        bondService.createBond(testBond);
        
        List<BondModel> bonds = bondService.getBondsByType("Government");
        assertFalse(bonds.isEmpty());
        assertEquals("Government", bonds.get(0).getBondType());
    }

    @Test
    void shouldUpdateBond() {
        BondModel created = bondService.createBond(testBond);
        created.setBondType("Corporate");
        created.setIssuer("Updated Issuer");
        
        BondModel updated = bondService.updateBond(created.getId(), created);
        assertEquals("Corporate", updated.getBondType());
        assertEquals("Updated Issuer", updated.getIssuer());
    }

    @Test
    void shouldDeleteBond() {
        BondModel created = bondService.createBond(testBond);
        bondService.deleteBond(created.getId());
        
        assertTrue(bondRepository.findById(created.getId()).isEmpty());
    }
}

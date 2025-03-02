// package com.am.common.amcommondata.service;

// import com.am.common.amcommondata.domain.asset.gold.Gold;
// import com.am.common.amcommondata.model.asset.gold.GoldModel;
// import com.am.common.amcommondata.repository.asset.gold.GoldRepository;
// import com.am.common.amcommondata.service.asset.GoldService;
// import com.am.common.amcommondata.service.mapper.asset.GoldMapper;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.DynamicPropertyRegistry;
// import org.springframework.test.context.DynamicPropertySource;
// import org.testcontainers.containers.PostgreSQLContainer;
// import org.testcontainers.junit.jupiter.Container;
// import org.testcontainers.junit.jupiter.Testcontainers;

// import java.util.List;
// import java.util.UUID;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.junit.jupiter.api.Assertions.*;

// @SpringBootTest
// @Testcontainers
// class GoldServiceContainerTest {

//     @Container
//     static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.2")
//             .withDatabaseName("testdb")
//             .withUsername("test")
//             .withPassword("test");

//     @DynamicPropertySource
//     static void configureProperties(DynamicPropertyRegistry registry) {
//         registry.add("spring.datasource.url", postgres::getJdbcUrl);
//         registry.add("spring.datasource.username", postgres::getUsername);
//         registry.add("spring.datasource.password", postgres::getPassword);
//     }

//     @Autowired
//     private GoldService goldService;

//     @Autowired
//     private GoldRepository goldRepository;

//     @Autowired
//     private GoldMapper goldMapper;

//     private GoldModel testGold;

//     @BeforeEach
//     void setUp() {
//         goldRepository.deleteAll();
        
//         testGold = GoldModel.builder()
//                 .weight(100.0)
//                 .purity(24.0)
//                 .form("Physical")
//                 .location("Test Vault")
//                 .purchasePrice(50000.0)
//                 .currentMarketPrice(55000.0)
//                 .build();
//     }

//     @Test
//     void shouldCreateGold() {
//         GoldModel created = goldService.createGold(testGold);
        
//         assertNotNull(created.getId());
//         assertEquals(testGold.getWeight(), created.getWeight());
//         assertEquals(testGold.getPurity(), created.getPurity());
//     }

//     @Test
//     void shouldGetGold() {
//         GoldModel created = goldService.createGold(testGold);
//         GoldModel found = goldService.getGold(created.getId());
        
//         assertEquals(created.getId(), found.getId());
//         assertEquals(created.getWeight(), found.getWeight());
//     }

//     @Test
//     void shouldGetAllGold() {
//         goldService.createGold(testGold);
        
//         GoldModel secondGold = GoldModel.builder()
//                 .weight(50.0)
//                 .purity(22.0)
//                 .form("Digital")
//                 .location("Digital Vault")
//                 .purchasePrice(25000.0)
//                 .currentMarketPrice(27000.0)
//                 .build();
//         goldService.createGold(secondGold);

//         List<GoldModel> goldList = goldService.getAllGold();
//         assertEquals(2, goldList.size());
//     }

//     @Test
//     void shouldGetGoldByPurity() {
//         goldService.createGold(testGold);
        
//         List<GoldModel> goldList = goldService.getGoldByPurity(24.0);
//         assertFalse(goldList.isEmpty());
//         assertEquals(24.0, goldList.get(0).getPurity());
//     }

//     @Test
//     void shouldUpdateGold() {
//         GoldModel created = goldService.createGold(testGold);
//         created.setWeight(150.0);
        
//         GoldModel updated = goldService.updateGold(created.getId(), created);
//         assertEquals(150.0, updated.getWeight());
//     }

//     @Test
//     void shouldDeleteGold() {
//         GoldModel created = goldService.createGold(testGold);
//         goldService.deleteGold(created.getId());
        
//         assertTrue(goldRepository.findById(created.getId()).isEmpty());
//     }
// }

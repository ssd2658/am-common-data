// package com.am.common.amcommondata.service;

// import com.am.common.amcommondata.domain.asset.pension.NPS;
// import com.am.common.amcommondata.model.asset.pension.NPSModel;
// import com.am.common.amcommondata.repository.asset.pension.PensionRepository;
// import com.am.common.amcommondata.service.asset.NPSService;
// import com.am.common.amcommondata.service.mapper.asset.NPSMapper;
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
// class NPSServiceContainerTest {

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
//     private NPSService npsService;

//     @Autowired
//     private PensionRepository pensionRepository;

//     @Autowired
//     private NPSMapper npsMapper;

//     private NPSModel testNPS;

//     @BeforeEach
//     void setUp() {
//         pensionRepository.deleteAll();
        
//         testNPS = NPSModel.builder()
//                 .schemeType("Tier 1")
//                 .pran("TEST123456")
//                 .assetAllocation("Auto")
//                 .equityPercentage(75.0)
//                 .corporateBondPercentage(15.0)
//                 .governmentBondPercentage(10.0)
//                 .employeeContribution(50000.0)
//                 .employerContribution(50000.0)
//                 .currentValue(110000.0)
//                 .build();
//     }

//     @Test
//     void shouldCreateNPS() {
//         NPSModel created = npsService.createNPS(testNPS);
        
//         assertNotNull(created.getId());
//         assertEquals(testNPS.getSchemeType(), created.getSchemeType());
//         assertEquals(testNPS.getPran(), created.getPran());
//     }

//     @Test
//     void shouldGetNPS() {
//         NPSModel created = npsService.createNPS(testNPS);
//         NPSModel found = npsService.getNPS(created.getId());
        
//         assertEquals(created.getId(), found.getId());
//         assertEquals(created.getSchemeType(), found.getSchemeType());
//     }

//     @Test
//     void shouldGetAllNPS() {
//         npsService.createNPS(testNPS);
        
//         NPSModel secondNPS = NPSModel.builder()
//                 .schemeType("Tier 2")
//                 .pran("TEST654321")
//                 .assetAllocation("Conservative")
//                 .equityPercentage(25.0)
//                 .corporateBondPercentage(35.0)
//                 .governmentBondPercentage(40.0)
//                 .employeeContribution(30000.0)
//                 .employerContribution(20000.0)
//                 .currentValue(52000.0)
//                 .build();
//         npsService.createNPS(secondNPS);

//         List<NPSModel> npsList = npsService.getAllNPS();
//         assertEquals(2, npsList.size());
//     }

//     @Test
//     void shouldGetNPSBySchemeType() {
//         npsService.createNPS(testNPS);
        
//         List<NPSModel> npsList = npsService.getNPSBySchemeType("Tier 1");
//         assertFalse(npsList.isEmpty());
//         assertEquals("Tier 1", npsList.get(0).getSchemeType());
//     }

//     @Test
//     void shouldGetHighPerformingSchemes() {
//         npsService.createNPS(testNPS);
        
//         List<NPSModel> highPerformingSchemes = npsService.getHighPerformingSchemes(5.0);
//         assertFalse(highPerformingSchemes.isEmpty());
//     }

//     @Test
//     void shouldUpdateNPS() {
//         NPSModel created = npsService.createNPS(testNPS);
//         created.setEquityPercentage(80.0);
        
//         NPSModel updated = npsService.updateNPS(created.getId(), created);
//         assertEquals(80.0, updated.getEquityPercentage());
//     }

//     @Test
//     void shouldDeleteNPS() {
//         NPSModel created = npsService.createNPS(testNPS);
//         npsService.deleteNPS(created.getId());
        
//         assertTrue(pensionRepository.findById(created.getId()).isEmpty());
//     }
// }

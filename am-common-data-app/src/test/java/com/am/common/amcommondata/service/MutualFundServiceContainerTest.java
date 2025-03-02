// package com.am.common.amcommondata.service;

// import com.am.common.amcommondata.domain.asset.mutualfund.MutualFund;
// import com.am.common.amcommondata.model.asset.mutualfund.MutualFundModel;
// import com.am.common.amcommondata.repository.asset.mutualfund.MutualFundRepository;
// import com.am.common.amcommondata.service.asset.MutualFundService;
// import com.am.common.amcommondata.service.mapper.asset.MutualFundMapper;
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
// class MutualFundServiceContainerTest {

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
//     private MutualFundService mutualFundService;

//     @Autowired
//     private MutualFundRepository mutualFundRepository;

//     @Autowired
//     private MutualFundMapper mutualFundMapper;

//     private MutualFundModel testFund;

//     @BeforeEach
//     void setUp() {
//         mutualFundRepository.deleteAll();
        
//         testFund = MutualFundModel.builder()
//                 .fundName("Test Fund")
//                 .fundCategory("Equity")
//                 .fundHouse("Test AMC")
//                 .nav(25.5)
//                 .aum(1000000000.0)
//                 .expenseRatio(1.5)
//                 .exitLoad(1.0)
//                 .build();
//     }

//     @Test
//     void shouldCreateMutualFund() {
//         MutualFundModel created = mutualFundService.createMutualFund(testFund);
        
//         assertNotNull(created.getId());
//         assertEquals(testFund.getFundName(), created.getFundName());
//         assertEquals(testFund.getFundCategory(), created.getFundCategory());
//     }

//     @Test
//     void shouldGetMutualFund() {
//         MutualFundModel created = mutualFundService.createMutualFund(testFund);
//         MutualFundModel found = mutualFundService.getMutualFund(created.getId());
        
//         assertEquals(created.getId(), found.getId());
//         assertEquals(created.getFundName(), found.getFundName());
//     }

//     @Test
//     void shouldGetAllMutualFunds() {
//         mutualFundService.createMutualFund(testFund);
        
//         MutualFundModel secondFund = MutualFundModel.builder()
//                 .fundName("Second Fund")
//                 .fundCategory("Debt")
//                 .fundHouse("Test AMC")
//                 .nav(15.5)
//                 .aum(500000000.0)
//                 .expenseRatio(0.5)
//                 .exitLoad(0.0)
//                 .build();
//         mutualFundService.createMutualFund(secondFund);

//         List<MutualFundModel> funds = mutualFundService.getAllMutualFunds();
//         assertEquals(2, funds.size());
//     }

//     @Test
//     void shouldGetMutualFundsByCategory() {
//         mutualFundService.createMutualFund(testFund);
        
//         List<MutualFundModel> funds = mutualFundService.getMutualFundsByCategory("Equity");
//         assertFalse(funds.isEmpty());
//         assertEquals("Equity", funds.get(0).getFundCategory());
//     }

//     @Test
//     void shouldUpdateMutualFund() {
//         MutualFundModel created = mutualFundService.createMutualFund(testFund);
//         created.setNav(26.5);
        
//         MutualFundModel updated = mutualFundService.updateMutualFund(created.getId(), created);
//         assertEquals(26.5, updated.getNav());
//     }

//     @Test
//     void shouldDeleteMutualFund() {
//         MutualFundModel created = mutualFundService.createMutualFund(testFund);
//         mutualFundService.deleteMutualFund(created.getId());
        
//         assertTrue(mutualFundRepository.findById(created.getId()).isEmpty());
//     }
// }

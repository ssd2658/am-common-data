// package com.am.common.amcommondata.service;

// import com.am.common.amcommondata.domain.asset.realestate.RealEstate;
// import com.am.common.amcommondata.model.asset.realestate.RealEstateModel;
// import com.am.common.amcommondata.repository.asset.realestate.RealEstateRepository;
// import com.am.common.amcommondata.service.asset.RealEstateService;
// import com.am.common.amcommondata.service.mapper.asset.RealEstateMapper;
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
// class RealEstateServiceContainerTest {

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
//     private RealEstateService realEstateService;

//     @Autowired
//     private RealEstateRepository realEstateRepository;

//     @Autowired
//     private RealEstateMapper realEstateMapper;

//     private RealEstateModel testProperty;

//     @BeforeEach
//     void setUp() {
//         realEstateRepository.deleteAll();
        
//         testProperty = RealEstateModel.builder()
//                 .propertyName("Test Property")
//                 .propertyType("Residential")
//                 .location("Test City")
//                 .area(2000.0)
//                 .purchasePrice(5000000.0)
//                 .currentMarketValue(6000000.0)
//                 .rentalIncome(25000.0)
//                 .build();
//     }

//     @Test
//     void shouldCreateRealEstate() {
//         RealEstateModel created = realEstateService.createRealEstate(testProperty);
        
//         assertNotNull(created.getId());
//         assertEquals(testProperty.getPropertyName(), created.getPropertyName());
//         assertEquals(testProperty.getPropertyType(), created.getPropertyType());
//     }

//     @Test
//     void shouldGetRealEstate() {
//         RealEstateModel created = realEstateService.createRealEstate(testProperty);
//         RealEstateModel found = realEstateService.getRealEstate(created.getId());
        
//         assertEquals(created.getId(), found.getId());
//         assertEquals(created.getPropertyName(), found.getPropertyName());
//     }

//     @Test
//     void shouldGetAllRealEstate() {
//         realEstateService.createRealEstate(testProperty);
        
//         RealEstateModel secondProperty = RealEstateModel.builder()
//                 .propertyName("Second Property")
//                 .propertyType("Commercial")
//                 .location("Second City")
//                 .area(1000.0)
//                 .purchasePrice(10000000.0)
//                 .currentMarketValue(12000000.0)
//                 .rentalIncome(100000.0)
//                 .build();
//         realEstateService.createRealEstate(secondProperty);

//         List<RealEstateModel> properties = realEstateService.getAllRealEstate();
//         assertEquals(2, properties.size());
//     }

//     @Test
//     void shouldGetRealEstateByType() {
//         realEstateService.createRealEstate(testProperty);
        
//         List<RealEstateModel> properties = realEstateService.getRealEstateByType("Residential");
//         assertFalse(properties.isEmpty());
//         assertEquals("Residential", properties.get(0).getPropertyType());
//     }

//     @Test
//     void shouldUpdateRealEstate() {
//         RealEstateModel created = realEstateService.createRealEstate(testProperty);
//         created.setCurrentMarketValue(7000000.0);
        
//         RealEstateModel updated = realEstateService.updateRealEstate(created.getId(), created);
//         assertEquals(7000000.0, updated.getCurrentMarketValue());
//     }

//     @Test
//     void shouldDeleteRealEstate() {
//         RealEstateModel created = realEstateService.createRealEstate(testProperty);
//         realEstateService.deleteRealEstate(created.getId());
        
//         assertTrue(realEstateRepository.findById(created.getId()).isEmpty());
//     }
// }

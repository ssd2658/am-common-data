package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.model.asset.realestate.RealEstateModel;
import com.am.common.amcommondata.repository.asset.realestate.RealEstateRepository;
import com.am.common.amcommondata.service.mapper.asset.RealEstateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RealEstateService {
    private final RealEstateRepository realEstateRepository;
    private final RealEstateMapper realEstateMapper;

    public RealEstateModel getRealEstate(UUID id) {
        return realEstateRepository.findById(id)
                .map(realEstateMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Real Estate not found: " + id));
    }

    public List<RealEstateModel> getAllRealEstates() {
        return realEstateRepository.findAll().stream()
                .map(realEstateMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<RealEstateModel> getRealEstatesByType(String propertyType) {
        return realEstateRepository.findByPropertyType(propertyType).stream()
                .map(realEstateMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<RealEstateModel> getRentGeneratingProperties() {
        return realEstateRepository.findRentGeneratingProperties().stream()
                .map(realEstateMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public RealEstateModel createRealEstate(RealEstateModel realEstateModel) {
        var realEstate = realEstateMapper.toEntity(realEstateModel);
        realEstate = realEstateRepository.save(realEstate);
        return realEstateMapper.toModel(realEstate);
    }

    @Transactional
    public RealEstateModel updateRealEstate(Long id, RealEstateModel realEstateModel) {
        var existingRealEstate = realEstateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Real Estate not found: " + id));
        var updatedRealEstate = realEstateMapper.updateEntity(existingRealEstate, realEstateModel);
        updatedRealEstate = realEstateRepository.save(updatedRealEstate);
        return realEstateMapper.toModel(updatedRealEstate);
    }

    @Transactional
    public void deleteRealEstate(Long id) {
        realEstateRepository.deleteById(id);
    }
}

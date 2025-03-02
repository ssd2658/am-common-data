package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.gold.Gold;
import com.am.common.amcommondata.model.asset.gold.GoldModel;
import com.am.common.amcommondata.repository.asset.gold.GoldRepository;
import com.am.common.amcommondata.service.mapper.asset.GoldMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GoldService {
    private final GoldRepository goldRepository;
    private final GoldMapper goldMapper;

    public GoldModel getGold(UUID id) {
        return goldRepository.findById(id)
                .map(goldMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Gold not found: " + id));
    }

    public List<GoldModel> getAllGold() {
        return goldRepository.findAll().stream()
                .map(goldMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<GoldModel> getGoldByPurity(Double purity) {
        return goldRepository.findByMinimumPurity(purity).stream()
                .map(goldMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public GoldModel createGold(GoldModel model) {
        Gold entity = goldMapper.toEntity(model);
        entity = goldRepository.save(entity);
        return goldMapper.toModel(entity);
    }

    @Transactional
    public GoldModel updateGold(Long id, GoldModel model) {
        Gold existingGold = goldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gold not found: " + id));
        Gold updatedGold = goldMapper.updateEntity(existingGold, model);
        updatedGold = goldRepository.save(updatedGold);
        return goldMapper.toModel(updatedGold);
    }

    @Transactional
    public void deleteGold(Long id) {
        goldRepository.deleteById(id);
    }
}

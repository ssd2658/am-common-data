package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.bond.Bond;
import com.am.common.amcommondata.model.asset.bond.BondModel;
import com.am.common.amcommondata.repository.asset.bond.BondRepository;
import com.am.common.amcommondata.service.mapper.asset.BondMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BondService {
    private final BondRepository bondRepository;
    private final BondMapper bondMapper;

    public BondModel getBond(Long id) {
        return bondRepository.findById(id)
                .map(bondMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Bond not found: " + id));
    }

    public List<BondModel> getAllBonds() {
        return bondRepository.findAll().stream()
                .map(bondMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<BondModel> getBondsByType(String bondType) {
        return bondRepository.findByBondInfoBondType(bondType).stream()
                .map(bondMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public BondModel createBond(BondModel model) {
        Bond entity = bondMapper.toEntity(model);
        entity = bondRepository.save(entity);
        return bondMapper.toModel(entity);
    }

    @Transactional
    public BondModel updateBond(Long id, BondModel model) {
        Bond existingBond = bondRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bond not found: " + id));
        Bond updatedBond = bondMapper.updateEntity(existingBond, model);
        updatedBond = bondRepository.save(updatedBond);
        return bondMapper.toModel(updatedBond);
    }

    @Transactional
    public void deleteBond(Long id) {
        bondRepository.deleteById(id);
    }
}

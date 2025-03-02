package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.mutualfund.MutualFund;
import com.am.common.amcommondata.model.asset.mutualfund.MutualFundModel;
import com.am.common.amcommondata.repository.asset.mutualfund.MutualFundRepository;
import com.am.common.amcommondata.service.mapper.asset.MutualFundMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MutualFundService {
    private final MutualFundRepository mutualFundRepository;
    private final MutualFundMapper mutualFundMapper;

    public MutualFundModel getMutualFund(Long id) {
        return mutualFundRepository.findById(id)
                .map(mutualFundMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Mutual Fund not found: " + id));
    }

    public List<MutualFundModel> getAllMutualFunds() {
        return mutualFundRepository.findAll().stream()
                .map(mutualFundMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<MutualFundModel> getMutualFundsByCategory(String category) {
        return mutualFundRepository.findByFundInfoFundCategory(category).stream()
                .map(mutualFundMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public MutualFundModel createMutualFund(MutualFundModel model) {
        MutualFund entity = mutualFundMapper.toEntity(model);
        entity = mutualFundRepository.save(entity);
        return mutualFundMapper.toModel(entity);
    }

    @Transactional
    public MutualFundModel updateMutualFund(Long id, MutualFundModel model) {
        MutualFund existingFund = mutualFundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mutual Fund not found: " + id));
        MutualFund updatedFund = mutualFundMapper.updateEntity(existingFund, model);
        updatedFund = mutualFundRepository.save(updatedFund);
        return mutualFundMapper.toModel(updatedFund);
    }

    @Transactional
    public void deleteMutualFund(Long id) {
        mutualFundRepository.deleteById(id);
    }
}

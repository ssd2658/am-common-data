package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.fixeddeposit.FixedDeposit;
import com.am.common.amcommondata.model.asset.fixeddeposit.FixedDepositModel;
import com.am.common.amcommondata.repository.asset.fixeddeposit.FixedDepositRepository;
import com.am.common.amcommondata.service.mapper.asset.FixedDepositMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FixedDepositService {
    private final FixedDepositRepository fixedDepositRepository;
    private final FixedDepositMapper fixedDepositMapper;

    public FixedDepositModel getFixedDeposit(UUID id) {
        return fixedDepositRepository.findById(id)
                .map(fixedDepositMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Fixed Deposit not found: " + id));
    }

    public List<FixedDepositModel> getAllFixedDeposits() {
        return fixedDepositRepository.findAll().stream()
                .map(fixedDepositMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<FixedDepositModel> getFixedDepositsByBank(String bankName) {
        return fixedDepositRepository.findByBankName(bankName).stream()
                .map(fixedDepositMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public FixedDepositModel createFixedDeposit(FixedDepositModel model) {
        FixedDeposit entity = fixedDepositMapper.toEntity(model);
        entity = fixedDepositRepository.save(entity);
        return fixedDepositMapper.toModel(entity);
    }

    @Transactional
    public FixedDepositModel updateFixedDeposit(UUID id, FixedDepositModel model) {
        FixedDeposit existingFD = fixedDepositRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fixed Deposit not found: " + id));
        FixedDeposit updatedFD = fixedDepositMapper.updateEntity(existingFD, model);
        updatedFD = fixedDepositRepository.save(updatedFD);
        return fixedDepositMapper.toModel(updatedFD);
    }

    @Transactional
    public void deleteFixedDeposit(UUID id) {
        fixedDepositRepository.deleteById(id);
    }
}

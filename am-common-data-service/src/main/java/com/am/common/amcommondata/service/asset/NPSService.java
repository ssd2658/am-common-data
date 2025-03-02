package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.pension.NPS;
import com.am.common.amcommondata.model.asset.pension.NPSModel;
import com.am.common.amcommondata.repository.asset.pension.PensionRepository;
import com.am.common.amcommondata.service.mapper.asset.NPSMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NPSService {
    private final PensionRepository pensionRepository;
    private final NPSMapper npsMapper;

    public NPSModel getNPS(UUID id) {
        return pensionRepository.findById(id)
                .map(npsMapper::toModel)
                .orElseThrow(() -> new RuntimeException("NPS not found: " + id));
    }

    public List<NPSModel> getAllNPS() {
        return pensionRepository.findAll().stream()
                .map(npsMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<NPSModel> getNPSBySchemeType(String schemeType) {
        return pensionRepository.findBySchemeType(schemeType).stream()
                .map(npsMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<NPSModel> getHighPerformingSchemes(Double minReturn) {
        return pensionRepository.findHighPerformingSchemes(minReturn).stream()
                .map(npsMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public NPSModel createNPS(NPSModel model) {
        NPS entity = npsMapper.toEntity(model);
        entity = pensionRepository.save(entity);
        return npsMapper.toModel(entity);
    }

    @Transactional
    public NPSModel updateNPS(UUID id, NPSModel model) {
        NPS existingNPS = pensionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NPS not found: " + id));
        NPS updatedNPS = npsMapper.updateEntity(existingNPS, model);
        updatedNPS = pensionRepository.save(updatedNPS);
        return npsMapper.toModel(updatedNPS);
    }

    @Transactional
    public void deleteNPS(UUID id) {
        pensionRepository.deleteById(id);
    }
}

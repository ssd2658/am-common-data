package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.Asset;
import com.am.common.amcommondata.model.asset.AssetModel;
import com.am.common.amcommondata.repository.asset.AssetRepository;
import com.am.common.amcommondata.service.mapper.AssetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {
    private final AssetRepository assetRepository;
    private final AssetMapper assetMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AssetModel> getAllAssets() {
        return assetRepository.findAll().stream()
                .map(assetMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public AssetModel getAssetById(UUID id) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        return assetMapper.toModel(asset);
    }

    @Override
    @Transactional
    public AssetModel createAsset(AssetModel assetModel) {
        Asset asset = assetMapper.toEntity(assetModel);
        asset = assetRepository.save(asset);
        return assetMapper.toModel(asset);
    }

    @Override
    @Transactional
    public AssetModel updateAsset(UUID id, AssetModel assetModel) {
        Asset existingAsset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + id));
        
        Asset updatedAsset = assetMapper.updateEntity(existingAsset, assetModel);
        updatedAsset = assetRepository.save(updatedAsset);
        return assetMapper.toModel(updatedAsset);
    }

    @Override
    @Transactional
    public void deleteAsset(UUID id) {
        assetRepository.deleteById(id);
    }
}

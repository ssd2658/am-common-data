package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.model.asset.AssetModel;
import java.util.List;
import java.util.UUID;

public interface AssetService {
    List<AssetModel> getAllAssets();
    AssetModel getAssetById(UUID id);
    AssetModel createAsset(AssetModel asset);
    AssetModel updateAsset(UUID id, AssetModel asset);
    void deleteAsset(UUID id);
}

package com.am.common.amcommondata.service;

import com.am.common.amcommondata.repository.portfolio.AssetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
@Transactional
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns a list of distinct ISINs across all assets
     * @return List of unique ISINs
     */
    public List<String> findDistinctIsins() {
        return entityManager.createQuery(
            "SELECT DISTINCT a.isin FROM Asset a WHERE a.isin IS NOT NULL", 
            String.class
        ).getResultList();
    }
}

package com.am.common.amcommondata.service;

import com.am.common.amcommondata.domain.portfolio.Portfolio;
import com.am.common.amcommondata.mapper.PortfolioMapper;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.repository.portfolio.PortfolioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PortfolioServiceImpl implements PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    @Override
    public List<PortfolioModel> getPortfoliosByUserId(String userId) {
        return portfolioRepository.findByOwner(userId).stream()
                .map(portfolioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public PortfolioModel getPortfolioById(UUID id) {
        return portfolioMapper.toModel(portfolioRepository.findById(id).orElseThrow());
    }

    @Transactional
    public PortfolioModel createPortfolio(PortfolioModel portfolioModel) {
        Portfolio portfolio = portfolioMapper.toEntity(portfolioModel);
        
        // Set up bidirectional relationships for assets
        if (portfolio.getAssets() != null) {
            portfolio.getAssets().forEach(asset -> asset.setPortfolio(portfolio));
        }
        
        // Save portfolio with assets - CascadeType.ALL will handle asset persistence
        var savedPortfolio = portfolioRepository.save(portfolio);
        return portfolioMapper.toModel(savedPortfolio);
    }

    @Transactional
    public PortfolioModel updatePortfolio(UUID id, PortfolioModel portfolioModel) {
        Portfolio existingPortfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found: " + id));
        
        Portfolio updatedPortfolio = portfolioMapper.updateEntity(existingPortfolio, portfolioModel);
        updatedPortfolio = portfolioRepository.save(updatedPortfolio);
        return portfolioMapper.toModel(updatedPortfolio);
    }

    @Transactional
    public void deletePortfolio(UUID id) {
        portfolioRepository.deleteById(id);
    }

}

package com.am.common.amcommondata.service;

import com.am.common.amcommondata.domain.Portfolio;
import com.am.common.amcommondata.model.PortfolioModel;
import com.am.common.amcommondata.repository.PortfolioRepository;
import com.am.common.amcommondata.service.mapper.PortfolioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioMapper portfolioMapper;

    public PortfolioModel getPortfolio(Long id) {
        return portfolioRepository.findByIdWithAssets(id)
                .map(portfolioMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Portfolio not found: " + id));
    }

    public List<PortfolioModel> getAllPortfolios() {
        return portfolioRepository.findAll().stream()
                .map(portfolioMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<PortfolioModel> getPortfoliosByUser(String userId) {
        return portfolioRepository.findByCreatedBy(userId).stream()
                .map(portfolioMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public PortfolioModel createPortfolio(PortfolioModel portfolioModel) {
        Portfolio portfolio = portfolioMapper.toEntity(portfolioModel);
        portfolio = portfolioRepository.save(portfolio);
        return portfolioMapper.toModel(portfolio);
    }

    @Transactional
    public PortfolioModel updatePortfolio(Long id, PortfolioModel portfolioModel) {
        Portfolio existingPortfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found: " + id));
        
        Portfolio updatedPortfolio = portfolioMapper.updateEntity(existingPortfolio, portfolioModel);
        updatedPortfolio = portfolioRepository.save(updatedPortfolio);
        return portfolioMapper.toModel(updatedPortfolio);
    }

    @Transactional
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    public List<PortfolioModel> searchPortfolios(String query) {
        return portfolioRepository.findByNameContainingIgnoreCase(query).stream()
                .map(portfolioMapper::toModel)
                .collect(Collectors.toList());
    }
}

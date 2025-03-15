package com.am.common.amcommondata.service;


import com.am.common.amcommondata.model.PortfolioModel;
import java.util.List;
import java.util.UUID;

public interface PortfolioService {
    List<PortfolioModel> getPortfoliosByUserId(String userId);
    PortfolioModel getPortfolioById(UUID id);
    PortfolioModel createPortfolio(PortfolioModel portfolio);
    PortfolioModel updatePortfolio(UUID id, PortfolioModel portfolio);
    void deletePortfolio(UUID id);
}

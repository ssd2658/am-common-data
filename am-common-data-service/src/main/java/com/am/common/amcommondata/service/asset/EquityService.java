package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.model.asset.equity.EquityModel;
import com.am.common.amcommondata.repository.asset.equity.EquityRepository;
import com.am.common.amcommondata.service.mapper.asset.EquityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquityService {
    private final EquityRepository equityRepository;
    private final EquityMapper equityMapper;

    public EquityModel getEquity(String symbol) {
        return equityRepository.findEquityBySymbol(symbol)
                .map(equityMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Equity not found: " + symbol));
    }

    public List<EquityModel> getAllEquities() {
        return equityRepository.findAll().stream()
                .map(equityMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<EquityModel> getEquitiesBySector(String sector) {
        return equityRepository.findBySector(sector).stream()
                .map(equityMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<EquityModel> getHighDividendYieldStocks(Double minYield) {
        return equityRepository.findHighDividendYieldStocks(minYield).stream()
                .map(equityMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public EquityModel createEquity(EquityModel equityModel) {
        var equity = equityMapper.toEntity(equityModel);
        equity = equityRepository.save(equity);
        return equityMapper.toModel(equity);
    }

    @Transactional
    public EquityModel updateEquity(String symbol, EquityModel equityModel) {
        var existingEquity = equityRepository.findEquityBySymbol(symbol)
                .orElseThrow(() -> new RuntimeException("Equity not found: " + symbol));
        var updatedEquity = equityMapper.updateEntity(existingEquity, equityModel);
        updatedEquity = equityRepository.save(updatedEquity);
        return equityMapper.toModel(updatedEquity);
    }

}

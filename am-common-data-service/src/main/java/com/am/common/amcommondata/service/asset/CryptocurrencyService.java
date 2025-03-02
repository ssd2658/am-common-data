package com.am.common.amcommondata.service.asset;

import com.am.common.amcommondata.domain.asset.cryptocurrency.Cryptocurrency;
import com.am.common.amcommondata.model.asset.cryptocurrency.CryptocurrencyModel;
import com.am.common.amcommondata.repository.asset.cryptocurrency.CryptocurrencyRepository;
import com.am.common.amcommondata.service.mapper.asset.CryptocurrencyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final CryptocurrencyMapper cryptocurrencyMapper;

    public CryptocurrencyModel getCryptocurrency(Long id) {
        return cryptocurrencyRepository.findById(id)
                .map(cryptocurrencyMapper::toModel)
                .orElseThrow(() -> new RuntimeException("Cryptocurrency not found: " + id));
    }

    public List<CryptocurrencyModel> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll().stream()
                .map(cryptocurrencyMapper::toModel)
                .collect(Collectors.toList());
    }

    public List<CryptocurrencyModel> getCryptocurrenciesByBlockchain(String blockchain) {
        return cryptocurrencyRepository.findByCryptoInfoBlockchain(blockchain).stream()
                .map(cryptocurrencyMapper::toModel)
                .collect(Collectors.toList());
    }

    @Transactional
    public CryptocurrencyModel createCryptocurrency(CryptocurrencyModel model) {
        Cryptocurrency entity = cryptocurrencyMapper.toEntity(model);
        entity = cryptocurrencyRepository.save(entity);
        return cryptocurrencyMapper.toModel(entity);
    }

    @Transactional
    public CryptocurrencyModel updateCryptocurrency(Long id, CryptocurrencyModel model) {
        Cryptocurrency existingCrypto = cryptocurrencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cryptocurrency not found: " + id));
        Cryptocurrency updatedCrypto = cryptocurrencyMapper.updateEntity(existingCrypto, model);
        updatedCrypto = cryptocurrencyRepository.save(updatedCrypto);
        return cryptocurrencyMapper.toModel(updatedCrypto);
    }

    @Transactional
    public void deleteCryptocurrency(Long id) {
        cryptocurrencyRepository.deleteById(id);
    }
}

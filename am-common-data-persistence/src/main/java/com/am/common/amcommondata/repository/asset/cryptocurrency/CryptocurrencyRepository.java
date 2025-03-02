package com.am.common.amcommondata.repository.asset.cryptocurrency;

import com.am.common.amcommondata.domain.asset.cryptocurrency.Cryptocurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface CryptocurrencyRepository extends JpaRepository<Cryptocurrency, UUID> {
    List<Cryptocurrency> findByCryptoInfoBlockchain(String blockchain);
    
    List<Cryptocurrency> findByCryptoInfoTokenType(String tokenType);
    
    @Query("SELECT c FROM Cryptocurrency c WHERE c.cryptoInfo.marketCap >= :minMarketCap")
    List<Cryptocurrency> findByMinimumMarketCap(Double minMarketCap);
    
    List<Cryptocurrency> findByCryptoInfoStakingTrue();
    
    @Query("SELECT c FROM Cryptocurrency c WHERE c.cryptoInfo.stakingAPY >= :minAPY")
    List<Cryptocurrency> findByMinimumStakingAPY(Double minAPY);
    
    @Query("SELECT DISTINCT c.cryptoInfo.blockchain FROM Cryptocurrency c")
    List<String> findAllBlockchains();
    
    List<Cryptocurrency> findByCryptoInfoWalletType(String walletType);
}

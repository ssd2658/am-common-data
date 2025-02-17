package com.am.common.amcommondata.domain.asset.cryptocurrency;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.Embeddable;

@Data
@Embeddable
@SuperBuilder
@NoArgsConstructor
public class CryptoInfo {
    private String blockchain; // Bitcoin, Ethereum, etc.
    private String tokenType; // Native, ERC20, etc.
    private String contractAddress;
    private Integer decimals;
    private String networkType; // Mainnet, Testnet
    private String consensusMechanism;
    private Double circulatingSupply;
    private Double maxSupply;
    private String walletType; // Hot, Cold, Hardware
    private String walletAddress;
    private String storageMethod; // Exchange, Personal Wallet
    private String exchangeName;
    private String tradingPair;
    private Boolean staking;
    private Double stakingAPY;
    private String stakingPlatform;
}

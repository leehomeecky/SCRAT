package com.meecky.SCRAT.wallet.repository;

import com.meecky.SCRAT.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepo extends JpaRepository<WalletModel, Long> {
    Optional<WalletModel> findByAccountId(String accountId);
}

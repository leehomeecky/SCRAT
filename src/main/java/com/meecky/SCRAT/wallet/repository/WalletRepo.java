package com.meecky.SCRAT.wallet.repository;

import com.meecky.SCRAT.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<WalletModel, Long> {
}

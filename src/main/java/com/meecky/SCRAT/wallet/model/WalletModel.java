package com.meecky.SCRAT.wallet.model;

import com.meecky.SCRAT.wallet.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "wallet")
public class WalletModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String amount;
    @Column(name = "default_currency", columnDefinition = "VARCHAR(256) DEFAULT 'NGN'")
    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;
    @Column(name = "account_id", unique = true)
    private String accountId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
}

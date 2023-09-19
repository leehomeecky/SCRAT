package com.meecky.SCRAT.wallet.model;

import com.meecky.SCRAT.wallet.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "wallet")
@DynamicInsert
public class WalletModel {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String amount;
    @Column(columnDefinition = "VARCHAR(256) DEFAULT 'NGN'")
    @Enumerated(EnumType.STRING)
    private Currency defaultCurrency;
    @Column(name = "account_id", unique = true)
    private String accountId;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

package com.meecky.SCRAT.users.model;

import com.meecky.SCRAT.users.enums.EmailVerificationEnum;
import com.meecky.SCRAT.users.enums.Roles;
import com.meecky.SCRAT.users.enums.SubCycle;
import com.meecky.SCRAT.wallet.model.WalletModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
@DynamicInsert
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private Integer verificationPin;
    private LocalDateTime verificationExp;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'UN_VERIFIED'")
    @Enumerated(EnumType.STRING)
    private EmailVerificationEnum isVerified;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'MONTHLY'")
    @Enumerated(EnumType.STRING)
    private SubCycle subscriptionCycle;
    private String adminHash;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'USER'")
    @Enumerated(EnumType.STRING)
    private Roles roles;
    @OneToOne
    @JoinColumn(name = "wallet_id")
    private WalletModel walletId;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roles.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
